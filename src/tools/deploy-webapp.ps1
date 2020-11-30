param(  [Parameter(Mandatory=$False,HelpMessage="Webapp name")][String] $webapp="webmonitor",
    [Parameter(Mandatory=$True,HelpMessage="Location of war file to deploy")][String] $war="",
    [Parameter(Mandatory=$False,HelpMessage="Location of Apache Tomcat")][String] $tomcatdir="c:\app\perso\apache-tomcat-8.5.59")

# Do like : ps -ef | grep <pattern> command
function psef () {
    param([String] $filter)
    $filterParam="CommandLine like "+"'"+"%${filter}%"+"'"
    get-wmiobject Win32_Process -filter $filterParam | select-object Name,ProcessId,CommandLine
}

function isRunning() {
    param([String] $filter)
    $output = psef $filter
    return $output -ne $nul
}
$initialdir=get-location

if(-not (test-path $tomcatdir)) {
    Write-Error "Tomcat not found: $tomcatdir doesnt exist"
    exit 2
}
set-location $tomcatdir

Write-Output "Stopping Tomcat..."
& bin\shutdown.bat

while(isRunning catalina) {
    Write-Output "Waiting for catalina process to be stopped..."
    Start-Sleep -Seconds 1
}

if ( test-path webapps\$webapp ) {
    Write-Output "Deleting webapp $webapp ..."
    remove-item -force webapps\${webapp}.war
    remove-item -force -recurse webapps\$webapp
} else {
    Write-Output "No webapp $webapp to delete in ${tomcatdir}\webapps"
}

if(-not (Test-path $war))
{
    Write-Error "War file not found: $war doesnt exist"
    exit 2
} else {
    Write-Output "Deploying war $war ..."
    Copy-Item -Force $war webapps\
}

Write-Output "Starting Tomcat..."
&  bin\catalina.bat run

set-location $initialdir