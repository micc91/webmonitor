
package com.webops.duws.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.webops.duws.proxy package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetExecution_QNAME = new QName("http://duws.orsyp.com", "getExecution");
    private final static QName _StopQueueResponse_QNAME = new QName("http://duws.orsyp.com", "stopQueueResponse");
    private final static QName _GetLaunchResponse_QNAME = new QName("http://duws.orsyp.com", "getLaunchResponse");
    private final static QName _CreateOutageWindow_QNAME = new QName("http://duws.orsyp.com", "createOutageWindow");
    private final static QName _UpdateLaunchResponse_QNAME = new QName("http://duws.orsyp.com", "updateLaunchResponse");
    private final static QName _GetLaunchFromTaskResponse_QNAME = new QName("http://duws.orsyp.com", "getLaunchFromTaskResponse");
    private final static QName _EventItem_QNAME = new QName("http://duws.orsyp.com", "eventItem");
    private final static QName _GetEventResponse_QNAME = new QName("http://duws.orsyp.com", "getEventResponse");
    private final static QName _GetListEventResponse_QNAME = new QName("http://duws.orsyp.com", "getListEventResponse");
    private final static QName _SessionFilter_QNAME = new QName("http://duws.orsyp.com", "sessionFilter");
    private final static QName _Logout_QNAME = new QName("http://duws.orsyp.com", "logout");
    private final static QName _SessionNode_QNAME = new QName("http://duws.orsyp.com", "sessionNode");
    private final static QName _DeleteEvent_QNAME = new QName("http://duws.orsyp.com", "deleteEvent");
    private final static QName _PurgeExecutionResponse_QNAME = new QName("http://duws.orsyp.com", "purgeExecutionResponse");
    private final static QName _GetListOutage_QNAME = new QName("http://duws.orsyp.com", "getListOutage");
    private final static QName _RunBookFilter_QNAME = new QName("http://duws.orsyp.com", "runBookFilter");
    private final static QName _StopExecution_QNAME = new QName("http://duws.orsyp.com", "stopExecution");
    private final static QName _EventFilter_QNAME = new QName("http://duws.orsyp.com", "eventFilter");
    private final static QName _UpdateLaunch_QNAME = new QName("http://duws.orsyp.com", "updateLaunch");
    private final static QName _GetListSession_QNAME = new QName("http://duws.orsyp.com", "getListSession");
    private final static QName _GetExecutionLogResponse_QNAME = new QName("http://duws.orsyp.com", "getExecutionLogResponse");
    private final static QName _SkipExecution_QNAME = new QName("http://duws.orsyp.com", "skipExecution");
    private final static QName _GetExecutionResponse_QNAME = new QName("http://duws.orsyp.com", "getExecutionResponse");
    private final static QName _GetWsVersion_QNAME = new QName("http://duws.orsyp.com", "getWsVersion");
    private final static QName _DeleteOutageWindow_QNAME = new QName("http://duws.orsyp.com", "deleteOutageWindow");
    private final static QName _SkipExecutionResponse_QNAME = new QName("http://duws.orsyp.com", "skipExecutionResponse");
    private final static QName _UpdateEvent_QNAME = new QName("http://duws.orsyp.com", "updateEvent");
    private final static QName _UvmsContext_QNAME = new QName("http://duws.orsyp.com", "uvmsContext");
    private final static QName _LaunchId_QNAME = new QName("http://duws.orsyp.com", "launchId");
    private final static QName _GetExecutionLogAsAttachmentResponse_QNAME = new QName("http://duws.orsyp.com", "getExecutionLogAsAttachmentResponse");
    private final static QName _GetListNode_QNAME = new QName("http://duws.orsyp.com", "getListNode");
    private final static QName _GetLaunchFromTask_QNAME = new QName("http://duws.orsyp.com", "getLaunchFromTask");
    private final static QName _RestartEngineResponse_QNAME = new QName("http://duws.orsyp.com", "restartEngineResponse");
    private final static QName _GetSessionTreeResponse_QNAME = new QName("http://duws.orsyp.com", "getSessionTreeResponse");
    private final static QName _RunBook_QNAME = new QName("http://duws.orsyp.com", "runBook");
    private final static QName _Login_QNAME = new QName("http://duws.orsyp.com", "login");
    private final static QName _ResetQueue_QNAME = new QName("http://duws.orsyp.com", "resetQueue");
    private final static QName _DeleteOutageWindowResponse_QNAME = new QName("http://duws.orsyp.com", "deleteOutageWindowResponse");
    private final static QName _GetListUprocResponse_QNAME = new QName("http://duws.orsyp.com", "getListUprocResponse");
    private final static QName _StopQueue_QNAME = new QName("http://duws.orsyp.com", "stopQueue");
    private final static QName _MuItem_QNAME = new QName("http://duws.orsyp.com", "muItem");
    private final static QName _AcknowledgeExecutionResponse_QNAME = new QName("http://duws.orsyp.com", "acknowledgeExecutionResponse");
    private final static QName _OutageFilter_QNAME = new QName("http://duws.orsyp.com", "outageFilter");
    private final static QName _GetDUEnvironmentList_QNAME = new QName("http://duws.orsyp.com", "getDUEnvironmentList");
    private final static QName _HoldLaunchResponse_QNAME = new QName("http://duws.orsyp.com", "holdLaunchResponse");
    private final static QName _Event_QNAME = new QName("http://duws.orsyp.com", "event");
    private final static QName _DisableLaunch_QNAME = new QName("http://duws.orsyp.com", "disableLaunch");
    private final static QName _EnableLaunchResponse_QNAME = new QName("http://duws.orsyp.com", "enableLaunchResponse");
    private final static QName _GetExecutionLogAsAttachment_QNAME = new QName("http://duws.orsyp.com", "getExecutionLogAsAttachment");
    private final static QName _GetLaunch_QNAME = new QName("http://duws.orsyp.com", "getLaunch");
    private final static QName _TaskFilter_QNAME = new QName("http://duws.orsyp.com", "taskFilter");
    private final static QName _GetListTaskResponse_QNAME = new QName("http://duws.orsyp.com", "getListTaskResponse");
    private final static QName _EnableLaunch_QNAME = new QName("http://duws.orsyp.com", "enableLaunch");
    private final static QName _GetScriptResourceLogResponse_QNAME = new QName("http://duws.orsyp.com", "getScriptResourceLogResponse");
    private final static QName _GetSessionTree_QNAME = new QName("http://duws.orsyp.com", "getSessionTree");
    private final static QName _HistoryTrace_QNAME = new QName("http://duws.orsyp.com", "historyTrace");
    private final static QName _SessionItem_QNAME = new QName("http://duws.orsyp.com", "sessionItem");
    private final static QName _Launch_QNAME = new QName("http://duws.orsyp.com", "launch");
    private final static QName _GetRunBookExternalFile_QNAME = new QName("http://duws.orsyp.com", "getRunBookExternalFile");
    private final static QName _ReleaseLaunchResponse_QNAME = new QName("http://duws.orsyp.com", "releaseLaunchResponse");
    private final static QName _NodeFilter_QNAME = new QName("http://duws.orsyp.com", "nodeFilter");
    private final static QName _GetListLaunchResponse_QNAME = new QName("http://duws.orsyp.com", "getListLaunchResponse");
    private final static QName _ContextHolder_QNAME = new QName("http://duws.orsyp.com", "contextHolder");
    private final static QName _GetListExecutionResponse_QNAME = new QName("http://duws.orsyp.com", "getListExecutionResponse");
    private final static QName _ForceCompleteLaunch_QNAME = new QName("http://duws.orsyp.com", "forceCompleteLaunch");
    private final static QName _Queue_QNAME = new QName("http://duws.orsyp.com", "queue");
    private final static QName _ExecutionLog_QNAME = new QName("http://duws.orsyp.com", "executionLog");
    private final static QName _GetListUproc_QNAME = new QName("http://duws.orsyp.com", "getListUproc");
    private final static QName _UpdateEventResponse_QNAME = new QName("http://duws.orsyp.com", "updateEventResponse");
    private final static QName _StopEngineResponse_QNAME = new QName("http://duws.orsyp.com", "stopEngineResponse");
    private final static QName _RunNote_QNAME = new QName("http://duws.orsyp.com", "runNote");
    private final static QName _GetListSessionResponse_QNAME = new QName("http://duws.orsyp.com", "getListSessionResponse");
    private final static QName _GetDUEnvironmentListResponse_QNAME = new QName("http://duws.orsyp.com", "getDUEnvironmentListResponse");
    private final static QName _GetListNodeResponse_QNAME = new QName("http://duws.orsyp.com", "getListNodeResponse");
    private final static QName _SessionTimedOutException_QNAME = new QName("http://duws.orsyp.com", "SessionTimedOutException");
    private final static QName _ExecutionFilter_QNAME = new QName("http://duws.orsyp.com", "executionFilter");
    private final static QName _StartEngineResponse_QNAME = new QName("http://duws.orsyp.com", "startEngineResponse");
    private final static QName _GetEvent_QNAME = new QName("http://duws.orsyp.com", "getEvent");
    private final static QName _DuwsException_QNAME = new QName("http://duws.orsyp.com", "DuwsException");
    private final static QName _AddLaunchFromTask2_QNAME = new QName("http://duws.orsyp.com", "addLaunchFromTask2");
    private final static QName _DeleteLaunch_QNAME = new QName("http://duws.orsyp.com", "deleteLaunch");
    private final static QName _BypassLaunchConditionCheckResponse_QNAME = new QName("http://duws.orsyp.com", "bypassLaunchConditionCheckResponse");
    private final static QName _GetListExecution_QNAME = new QName("http://duws.orsyp.com", "getListExecution");
    private final static QName _ReleaseLaunch_QNAME = new QName("http://duws.orsyp.com", "releaseLaunch");
    private final static QName _LaunchFilter_QNAME = new QName("http://duws.orsyp.com", "launchFilter");
    private final static QName _ForceCompleteLaunchResponse_QNAME = new QName("http://duws.orsyp.com", "forceCompleteLaunchResponse");
    private final static QName _AddEvent_QNAME = new QName("http://duws.orsyp.com", "addEvent");
    private final static QName _RerunExecution_QNAME = new QName("http://duws.orsyp.com", "rerunExecution");
    private final static QName _UprocFilter_QNAME = new QName("http://duws.orsyp.com", "uprocFilter");
    private final static QName _GetHistoryTraceResponse_QNAME = new QName("http://duws.orsyp.com", "getHistoryTraceResponse");
    private final static QName _GetListOutageResponse_QNAME = new QName("http://duws.orsyp.com", "getListOutageResponse");
    private final static QName _AcknowledgeExecution_QNAME = new QName("http://duws.orsyp.com", "acknowledgeExecution");
    private final static QName _AddLaunchFromTask2Response_QNAME = new QName("http://duws.orsyp.com", "addLaunchFromTask2Response");
    private final static QName _UnacknowledgeExecution_QNAME = new QName("http://duws.orsyp.com", "unacknowledgeExecution");
    private final static QName _AddLaunch_QNAME = new QName("http://duws.orsyp.com", "addLaunch");
    private final static QName _LoginResponse_QNAME = new QName("http://duws.orsyp.com", "loginResponse");
    private final static QName _UprocItem_QNAME = new QName("http://duws.orsyp.com", "uprocItem");
    private final static QName _GetListMUResponse_QNAME = new QName("http://duws.orsyp.com", "getListMUResponse");
    private final static QName _GetWsVersionResponse_QNAME = new QName("http://duws.orsyp.com", "getWsVersionResponse");
    private final static QName _StopExecutionResponse_QNAME = new QName("http://duws.orsyp.com", "stopExecutionResponse");
    private final static QName _AddLaunchFromTaskResponse_QNAME = new QName("http://duws.orsyp.com", "addLaunchFromTaskResponse");
    private final static QName _GetListTask_QNAME = new QName("http://duws.orsyp.com", "getListTask");
    private final static QName _TaskItem_QNAME = new QName("http://duws.orsyp.com", "taskItem");
    private final static QName _GetRunBooks_QNAME = new QName("http://duws.orsyp.com", "getRunBooks");
    private final static QName _GetPreviousLaunches_QNAME = new QName("http://duws.orsyp.com", "getPreviousLaunches");
    private final static QName _GetScriptResourceLog_QNAME = new QName("http://duws.orsyp.com", "getScriptResourceLog");
    private final static QName _StopEngine_QNAME = new QName("http://duws.orsyp.com", "stopEngine");
    private final static QName _ExecutionItem_QNAME = new QName("http://duws.orsyp.com", "executionItem");
    private final static QName _StartQueue_QNAME = new QName("http://duws.orsyp.com", "startQueue");
    private final static QName _MuFilter_QNAME = new QName("http://duws.orsyp.com", "muFilter");
    private final static QName _RestartEngine_QNAME = new QName("http://duws.orsyp.com", "restartEngine");
    private final static QName _LogoutResponse_QNAME = new QName("http://duws.orsyp.com", "logoutResponse");
    private final static QName _PurgeExecution_QNAME = new QName("http://duws.orsyp.com", "purgeExecution");
    private final static QName _ResourceLog_QNAME = new QName("http://duws.orsyp.com", "resourceLog");
    private final static QName _StartEngine_QNAME = new QName("http://duws.orsyp.com", "startEngine");
    private final static QName _BypassLaunchConditionCheck_QNAME = new QName("http://duws.orsyp.com", "bypassLaunchConditionCheck");
    private final static QName _CreateOutageWindowResponse_QNAME = new QName("http://duws.orsyp.com", "createOutageWindowResponse");
    private final static QName _StartQueueResponse_QNAME = new QName("http://duws.orsyp.com", "startQueueResponse");
    private final static QName _PreviousLaunch_QNAME = new QName("http://duws.orsyp.com", "previousLaunch");
    private final static QName _DisableLaunchResponse_QNAME = new QName("http://duws.orsyp.com", "disableLaunchResponse");
    private final static QName _Engine_QNAME = new QName("http://duws.orsyp.com", "engine");
    private final static QName _RunNoteFilter_QNAME = new QName("http://duws.orsyp.com", "runNoteFilter");
    private final static QName _AddLaunchResponse_QNAME = new QName("http://duws.orsyp.com", "addLaunchResponse");
    private final static QName _GetPreviousLaunchesResponse_QNAME = new QName("http://duws.orsyp.com", "getPreviousLaunchesResponse");
    private final static QName _NodeItem_QNAME = new QName("http://duws.orsyp.com", "nodeItem");
    private final static QName _DeleteEventResponse_QNAME = new QName("http://duws.orsyp.com", "deleteEventResponse");
    private final static QName _GetListMU_QNAME = new QName("http://duws.orsyp.com", "getListMU");
    private final static QName _UvmsNodeFilter_QNAME = new QName("http://duws.orsyp.com", "uvmsNodeFilter");
    private final static QName _GetExecutionLog_QNAME = new QName("http://duws.orsyp.com", "getExecutionLog");
    private final static QName _GetHistoryTrace_QNAME = new QName("http://duws.orsyp.com", "getHistoryTrace");
    private final static QName _UnacknowledgeExecutionResponse_QNAME = new QName("http://duws.orsyp.com", "unacknowledgeExecutionResponse");
    private final static QName _RerunExecutionResponse_QNAME = new QName("http://duws.orsyp.com", "rerunExecutionResponse");
    private final static QName _DuwsVersion_QNAME = new QName("http://duws.orsyp.com", "duwsVersion");
    private final static QName _Execution_QNAME = new QName("http://duws.orsyp.com", "execution");
    private final static QName _GetListLaunch_QNAME = new QName("http://duws.orsyp.com", "getListLaunch");
    private final static QName _GetRunNotes_QNAME = new QName("http://duws.orsyp.com", "getRunNotes");
    private final static QName _OutageWindow_QNAME = new QName("http://duws.orsyp.com", "outageWindow");
    private final static QName _GetListEvent_QNAME = new QName("http://duws.orsyp.com", "getListEvent");
    private final static QName _GetRunBookExternalFileResponse_QNAME = new QName("http://duws.orsyp.com", "getRunBookExternalFileResponse");
    private final static QName _GetRunBooksResponse_QNAME = new QName("http://duws.orsyp.com", "getRunBooksResponse");
    private final static QName _LaunchItem_QNAME = new QName("http://duws.orsyp.com", "launchItem");
    private final static QName _AddEventResponse_QNAME = new QName("http://duws.orsyp.com", "addEventResponse");
    private final static QName _ResetQueueResponse_QNAME = new QName("http://duws.orsyp.com", "resetQueueResponse");
    private final static QName _GetRunNotesResponse_QNAME = new QName("http://duws.orsyp.com", "getRunNotesResponse");
    private final static QName _DeleteLaunchResponse_QNAME = new QName("http://duws.orsyp.com", "deleteLaunchResponse");
    private final static QName _HoldLaunch_QNAME = new QName("http://duws.orsyp.com", "holdLaunch");
    private final static QName _AddLaunchFromTask_QNAME = new QName("http://duws.orsyp.com", "addLaunchFromTask");
    private final static QName _SessionTree_QNAME = new QName("http://duws.orsyp.com", "sessionTree");
    private final static QName _Variable_QNAME = new QName("http://duws.orsyp.com", "variable");
    private final static QName _ExecutionIdSessionVersion_QNAME = new QName("http://duws.orsyp.com", "sessionVersion");
    private final static QName _ExecutionIdMu_QNAME = new QName("http://duws.orsyp.com", "mu");
    private final static QName _EnvirArea_QNAME = new QName("http://duws.orsyp.com", "area");
    private final static QName _EnvirStatus_QNAME = new QName("http://duws.orsyp.com", "status");
    private final static QName _EnvirVersion_QNAME = new QName("http://duws.orsyp.com", "version");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.webops.duws.proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Execution }
     * 
     */
    public Execution createExecution() {
        return new Execution();
    }

    /**
     * Create an instance of {@link Launch }
     * 
     */
    public Launch createLaunch() {
        return new Launch();
    }

    /**
     * Create an instance of {@link CreateOutageWindow }
     * 
     */
    public CreateOutageWindow createCreateOutageWindow() {
        return new CreateOutageWindow();
    }

    /**
     * Create an instance of {@link UpdateLaunchResponse }
     * 
     */
    public UpdateLaunchResponse createUpdateLaunchResponse() {
        return new UpdateLaunchResponse();
    }

    /**
     * Create an instance of {@link GetLaunchResponse }
     * 
     */
    public GetLaunchResponse createGetLaunchResponse() {
        return new GetLaunchResponse();
    }

    /**
     * Create an instance of {@link GetExecution }
     * 
     */
    public GetExecution createGetExecution() {
        return new GetExecution();
    }

    /**
     * Create an instance of {@link StopQueueResponse }
     * 
     */
    public StopQueueResponse createStopQueueResponse() {
        return new StopQueueResponse();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link GetEventResponse }
     * 
     */
    public GetEventResponse createGetEventResponse() {
        return new GetEventResponse();
    }

    /**
     * Create an instance of {@link GetListEventResponse }
     * 
     */
    public GetListEventResponse createGetListEventResponse() {
        return new GetListEventResponse();
    }

    /**
     * Create an instance of {@link SessionFilter }
     * 
     */
    public SessionFilter createSessionFilter() {
        return new SessionFilter();
    }

    /**
     * Create an instance of {@link GetLaunchFromTaskResponse }
     * 
     */
    public GetLaunchFromTaskResponse createGetLaunchFromTaskResponse() {
        return new GetLaunchFromTaskResponse();
    }

    /**
     * Create an instance of {@link EventItem }
     * 
     */
    public EventItem createEventItem() {
        return new EventItem();
    }

    /**
     * Create an instance of {@link GetListOutage }
     * 
     */
    public GetListOutage createGetListOutage() {
        return new GetListOutage();
    }

    /**
     * Create an instance of {@link RunBookFilter }
     * 
     */
    public RunBookFilter createRunBookFilter() {
        return new RunBookFilter();
    }

    /**
     * Create an instance of {@link DeleteEvent }
     * 
     */
    public DeleteEvent createDeleteEvent() {
        return new DeleteEvent();
    }

    /**
     * Create an instance of {@link PurgeExecutionResponse }
     * 
     */
    public PurgeExecutionResponse createPurgeExecutionResponse() {
        return new PurgeExecutionResponse();
    }

    /**
     * Create an instance of {@link SessionNode }
     * 
     */
    public SessionNode createSessionNode() {
        return new SessionNode();
    }

    /**
     * Create an instance of {@link GetListSession }
     * 
     */
    public GetListSession createGetListSession() {
        return new GetListSession();
    }

    /**
     * Create an instance of {@link EventFilter }
     * 
     */
    public EventFilter createEventFilter() {
        return new EventFilter();
    }

    /**
     * Create an instance of {@link UpdateLaunch }
     * 
     */
    public UpdateLaunch createUpdateLaunch() {
        return new UpdateLaunch();
    }

    /**
     * Create an instance of {@link StopExecution }
     * 
     */
    public StopExecution createStopExecution() {
        return new StopExecution();
    }

    /**
     * Create an instance of {@link GetExecutionResponse }
     * 
     */
    public GetExecutionResponse createGetExecutionResponse() {
        return new GetExecutionResponse();
    }

    /**
     * Create an instance of {@link GetExecutionLogResponse }
     * 
     */
    public GetExecutionLogResponse createGetExecutionLogResponse() {
        return new GetExecutionLogResponse();
    }

    /**
     * Create an instance of {@link SkipExecution }
     * 
     */
    public SkipExecution createSkipExecution() {
        return new SkipExecution();
    }

    /**
     * Create an instance of {@link LaunchId }
     * 
     */
    public LaunchId createLaunchId() {
        return new LaunchId();
    }

    /**
     * Create an instance of {@link UvmsContext }
     * 
     */
    public UvmsContext createUvmsContext() {
        return new UvmsContext();
    }

    /**
     * Create an instance of {@link DeleteOutageWindow }
     * 
     */
    public DeleteOutageWindow createDeleteOutageWindow() {
        return new DeleteOutageWindow();
    }

    /**
     * Create an instance of {@link SkipExecutionResponse }
     * 
     */
    public SkipExecutionResponse createSkipExecutionResponse() {
        return new SkipExecutionResponse();
    }

    /**
     * Create an instance of {@link UpdateEvent }
     * 
     */
    public UpdateEvent createUpdateEvent() {
        return new UpdateEvent();
    }

    /**
     * Create an instance of {@link GetWsVersion }
     * 
     */
    public GetWsVersion createGetWsVersion() {
        return new GetWsVersion();
    }

    /**
     * Create an instance of {@link GetLaunchFromTask }
     * 
     */
    public GetLaunchFromTask createGetLaunchFromTask() {
        return new GetLaunchFromTask();
    }

    /**
     * Create an instance of {@link GetListNode }
     * 
     */
    public GetListNode createGetListNode() {
        return new GetListNode();
    }

    /**
     * Create an instance of {@link GetExecutionLogAsAttachmentResponse }
     * 
     */
    public GetExecutionLogAsAttachmentResponse createGetExecutionLogAsAttachmentResponse() {
        return new GetExecutionLogAsAttachmentResponse();
    }

    /**
     * Create an instance of {@link GetSessionTreeResponse }
     * 
     */
    public GetSessionTreeResponse createGetSessionTreeResponse() {
        return new GetSessionTreeResponse();
    }

    /**
     * Create an instance of {@link RestartEngineResponse }
     * 
     */
    public RestartEngineResponse createRestartEngineResponse() {
        return new RestartEngineResponse();
    }

    /**
     * Create an instance of {@link MuItem }
     * 
     */
    public MuItem createMuItem() {
        return new MuItem();
    }

    /**
     * Create an instance of {@link AcknowledgeExecutionResponse }
     * 
     */
    public AcknowledgeExecutionResponse createAcknowledgeExecutionResponse() {
        return new AcknowledgeExecutionResponse();
    }

    /**
     * Create an instance of {@link DeleteOutageWindowResponse }
     * 
     */
    public DeleteOutageWindowResponse createDeleteOutageWindowResponse() {
        return new DeleteOutageWindowResponse();
    }

    /**
     * Create an instance of {@link GetListUprocResponse }
     * 
     */
    public GetListUprocResponse createGetListUprocResponse() {
        return new GetListUprocResponse();
    }

    /**
     * Create an instance of {@link StopQueue }
     * 
     */
    public StopQueue createStopQueue() {
        return new StopQueue();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link ResetQueue }
     * 
     */
    public ResetQueue createResetQueue() {
        return new ResetQueue();
    }

    /**
     * Create an instance of {@link RunBook }
     * 
     */
    public RunBook createRunBook() {
        return new RunBook();
    }

    /**
     * Create an instance of {@link HoldLaunchResponse }
     * 
     */
    public HoldLaunchResponse createHoldLaunchResponse() {
        return new HoldLaunchResponse();
    }

    /**
     * Create an instance of {@link GetDUEnvironmentList }
     * 
     */
    public GetDUEnvironmentList createGetDUEnvironmentList() {
        return new GetDUEnvironmentList();
    }

    /**
     * Create an instance of {@link OutageFilter }
     * 
     */
    public OutageFilter createOutageFilter() {
        return new OutageFilter();
    }

    /**
     * Create an instance of {@link EnableLaunchResponse }
     * 
     */
    public EnableLaunchResponse createEnableLaunchResponse() {
        return new EnableLaunchResponse();
    }

    /**
     * Create an instance of {@link GetExecutionLogAsAttachment }
     * 
     */
    public GetExecutionLogAsAttachment createGetExecutionLogAsAttachment() {
        return new GetExecutionLogAsAttachment();
    }

    /**
     * Create an instance of {@link GetLaunch }
     * 
     */
    public GetLaunch createGetLaunch() {
        return new GetLaunch();
    }

    /**
     * Create an instance of {@link TaskFilter }
     * 
     */
    public TaskFilter createTaskFilter() {
        return new TaskFilter();
    }

    /**
     * Create an instance of {@link DisableLaunch }
     * 
     */
    public DisableLaunch createDisableLaunch() {
        return new DisableLaunch();
    }

    /**
     * Create an instance of {@link Event }
     * 
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link GetScriptResourceLogResponse }
     * 
     */
    public GetScriptResourceLogResponse createGetScriptResourceLogResponse() {
        return new GetScriptResourceLogResponse();
    }

    /**
     * Create an instance of {@link GetSessionTree }
     * 
     */
    public GetSessionTree createGetSessionTree() {
        return new GetSessionTree();
    }

    /**
     * Create an instance of {@link HistoryTrace }
     * 
     */
    public HistoryTrace createHistoryTrace() {
        return new HistoryTrace();
    }

    /**
     * Create an instance of {@link EnableLaunch }
     * 
     */
    public EnableLaunch createEnableLaunch() {
        return new EnableLaunch();
    }

    /**
     * Create an instance of {@link GetListTaskResponse }
     * 
     */
    public GetListTaskResponse createGetListTaskResponse() {
        return new GetListTaskResponse();
    }

    /**
     * Create an instance of {@link ReleaseLaunchResponse }
     * 
     */
    public ReleaseLaunchResponse createReleaseLaunchResponse() {
        return new ReleaseLaunchResponse();
    }

    /**
     * Create an instance of {@link NodeFilter }
     * 
     */
    public NodeFilter createNodeFilter() {
        return new NodeFilter();
    }

    /**
     * Create an instance of {@link GetRunBookExternalFile }
     * 
     */
    public GetRunBookExternalFile createGetRunBookExternalFile() {
        return new GetRunBookExternalFile();
    }

    /**
     * Create an instance of {@link SessionItem }
     * 
     */
    public SessionItem createSessionItem() {
        return new SessionItem();
    }

    /**
     * Create an instance of {@link ForceCompleteLaunch }
     * 
     */
    public ForceCompleteLaunch createForceCompleteLaunch() {
        return new ForceCompleteLaunch();
    }

    /**
     * Create an instance of {@link ContextHolder }
     * 
     */
    public ContextHolder createContextHolder() {
        return new ContextHolder();
    }

    /**
     * Create an instance of {@link GetListExecutionResponse }
     * 
     */
    public GetListExecutionResponse createGetListExecutionResponse() {
        return new GetListExecutionResponse();
    }

    /**
     * Create an instance of {@link GetListLaunchResponse }
     * 
     */
    public GetListLaunchResponse createGetListLaunchResponse() {
        return new GetListLaunchResponse();
    }

    /**
     * Create an instance of {@link ExecutionFilter }
     * 
     */
    public ExecutionFilter createExecutionFilter() {
        return new ExecutionFilter();
    }

    /**
     * Create an instance of {@link StartEngineResponse }
     * 
     */
    public StartEngineResponse createStartEngineResponse() {
        return new StartEngineResponse();
    }

    /**
     * Create an instance of {@link GetListSessionResponse }
     * 
     */
    public GetListSessionResponse createGetListSessionResponse() {
        return new GetListSessionResponse();
    }

    /**
     * Create an instance of {@link GetDUEnvironmentListResponse }
     * 
     */
    public GetDUEnvironmentListResponse createGetDUEnvironmentListResponse() {
        return new GetDUEnvironmentListResponse();
    }

    /**
     * Create an instance of {@link GetListNodeResponse }
     * 
     */
    public GetListNodeResponse createGetListNodeResponse() {
        return new GetListNodeResponse();
    }

    /**
     * Create an instance of {@link SessionTimedOutException }
     * 
     */
    public SessionTimedOutException createSessionTimedOutException() {
        return new SessionTimedOutException();
    }

    /**
     * Create an instance of {@link StopEngineResponse }
     * 
     */
    public StopEngineResponse createStopEngineResponse() {
        return new StopEngineResponse();
    }

    /**
     * Create an instance of {@link RunNote }
     * 
     */
    public RunNote createRunNote() {
        return new RunNote();
    }

    /**
     * Create an instance of {@link Queue }
     * 
     */
    public Queue createQueue() {
        return new Queue();
    }

    /**
     * Create an instance of {@link ExecutionLog }
     * 
     */
    public ExecutionLog createExecutionLog() {
        return new ExecutionLog();
    }

    /**
     * Create an instance of {@link GetListUproc }
     * 
     */
    public GetListUproc createGetListUproc() {
        return new GetListUproc();
    }

    /**
     * Create an instance of {@link UpdateEventResponse }
     * 
     */
    public UpdateEventResponse createUpdateEventResponse() {
        return new UpdateEventResponse();
    }

    /**
     * Create an instance of {@link GetEvent }
     * 
     */
    public GetEvent createGetEvent() {
        return new GetEvent();
    }

    /**
     * Create an instance of {@link DeleteLaunch }
     * 
     */
    public DeleteLaunch createDeleteLaunch() {
        return new DeleteLaunch();
    }

    /**
     * Create an instance of {@link AddLaunchFromTask2 }
     * 
     */
    public AddLaunchFromTask2 createAddLaunchFromTask2() {
        return new AddLaunchFromTask2();
    }

    /**
     * Create an instance of {@link DuwsException }
     * 
     */
    public DuwsException createDuwsException() {
        return new DuwsException();
    }

    /**
     * Create an instance of {@link AddEvent }
     * 
     */
    public AddEvent createAddEvent() {
        return new AddEvent();
    }

    /**
     * Create an instance of {@link RerunExecution }
     * 
     */
    public RerunExecution createRerunExecution() {
        return new RerunExecution();
    }

    /**
     * Create an instance of {@link ForceCompleteLaunchResponse }
     * 
     */
    public ForceCompleteLaunchResponse createForceCompleteLaunchResponse() {
        return new ForceCompleteLaunchResponse();
    }

    /**
     * Create an instance of {@link BypassLaunchConditionCheckResponse }
     * 
     */
    public BypassLaunchConditionCheckResponse createBypassLaunchConditionCheckResponse() {
        return new BypassLaunchConditionCheckResponse();
    }

    /**
     * Create an instance of {@link GetListExecution }
     * 
     */
    public GetListExecution createGetListExecution() {
        return new GetListExecution();
    }

    /**
     * Create an instance of {@link ReleaseLaunch }
     * 
     */
    public ReleaseLaunch createReleaseLaunch() {
        return new ReleaseLaunch();
    }

    /**
     * Create an instance of {@link LaunchFilter }
     * 
     */
    public LaunchFilter createLaunchFilter() {
        return new LaunchFilter();
    }

    /**
     * Create an instance of {@link GetHistoryTraceResponse }
     * 
     */
    public GetHistoryTraceResponse createGetHistoryTraceResponse() {
        return new GetHistoryTraceResponse();
    }

    /**
     * Create an instance of {@link GetListOutageResponse }
     * 
     */
    public GetListOutageResponse createGetListOutageResponse() {
        return new GetListOutageResponse();
    }

    /**
     * Create an instance of {@link UprocFilter }
     * 
     */
    public UprocFilter createUprocFilter() {
        return new UprocFilter();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link AddLaunch }
     * 
     */
    public AddLaunch createAddLaunch() {
        return new AddLaunch();
    }

    /**
     * Create an instance of {@link AcknowledgeExecution }
     * 
     */
    public AcknowledgeExecution createAcknowledgeExecution() {
        return new AcknowledgeExecution();
    }

    /**
     * Create an instance of {@link AddLaunchFromTask2Response }
     * 
     */
    public AddLaunchFromTask2Response createAddLaunchFromTask2Response() {
        return new AddLaunchFromTask2Response();
    }

    /**
     * Create an instance of {@link UnacknowledgeExecution }
     * 
     */
    public UnacknowledgeExecution createUnacknowledgeExecution() {
        return new UnacknowledgeExecution();
    }

    /**
     * Create an instance of {@link GetListMUResponse }
     * 
     */
    public GetListMUResponse createGetListMUResponse() {
        return new GetListMUResponse();
    }

    /**
     * Create an instance of {@link GetWsVersionResponse }
     * 
     */
    public GetWsVersionResponse createGetWsVersionResponse() {
        return new GetWsVersionResponse();
    }

    /**
     * Create an instance of {@link StopExecutionResponse }
     * 
     */
    public StopExecutionResponse createStopExecutionResponse() {
        return new StopExecutionResponse();
    }

    /**
     * Create an instance of {@link UprocItem }
     * 
     */
    public UprocItem createUprocItem() {
        return new UprocItem();
    }

    /**
     * Create an instance of {@link TaskItem }
     * 
     */
    public TaskItem createTaskItem() {
        return new TaskItem();
    }

    /**
     * Create an instance of {@link GetRunBooks }
     * 
     */
    public GetRunBooks createGetRunBooks() {
        return new GetRunBooks();
    }

    /**
     * Create an instance of {@link AddLaunchFromTaskResponse }
     * 
     */
    public AddLaunchFromTaskResponse createAddLaunchFromTaskResponse() {
        return new AddLaunchFromTaskResponse();
    }

    /**
     * Create an instance of {@link GetListTask }
     * 
     */
    public GetListTask createGetListTask() {
        return new GetListTask();
    }

    /**
     * Create an instance of {@link StartQueue }
     * 
     */
    public StartQueue createStartQueue() {
        return new StartQueue();
    }

    /**
     * Create an instance of {@link ExecutionItem }
     * 
     */
    public ExecutionItem createExecutionItem() {
        return new ExecutionItem();
    }

    /**
     * Create an instance of {@link GetPreviousLaunches }
     * 
     */
    public GetPreviousLaunches createGetPreviousLaunches() {
        return new GetPreviousLaunches();
    }

    /**
     * Create an instance of {@link GetScriptResourceLog }
     * 
     */
    public GetScriptResourceLog createGetScriptResourceLog() {
        return new GetScriptResourceLog();
    }

    /**
     * Create an instance of {@link StopEngine }
     * 
     */
    public StopEngine createStopEngine() {
        return new StopEngine();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link PurgeExecution }
     * 
     */
    public PurgeExecution createPurgeExecution() {
        return new PurgeExecution();
    }

    /**
     * Create an instance of {@link ResourceLog }
     * 
     */
    public ResourceLog createResourceLog() {
        return new ResourceLog();
    }

    /**
     * Create an instance of {@link StartEngine }
     * 
     */
    public StartEngine createStartEngine() {
        return new StartEngine();
    }

    /**
     * Create an instance of {@link MuFilter }
     * 
     */
    public MuFilter createMuFilter() {
        return new MuFilter();
    }

    /**
     * Create an instance of {@link RestartEngine }
     * 
     */
    public RestartEngine createRestartEngine() {
        return new RestartEngine();
    }

    /**
     * Create an instance of {@link PreviousLaunch }
     * 
     */
    public PreviousLaunch createPreviousLaunch() {
        return new PreviousLaunch();
    }

    /**
     * Create an instance of {@link StartQueueResponse }
     * 
     */
    public StartQueueResponse createStartQueueResponse() {
        return new StartQueueResponse();
    }

    /**
     * Create an instance of {@link BypassLaunchConditionCheck }
     * 
     */
    public BypassLaunchConditionCheck createBypassLaunchConditionCheck() {
        return new BypassLaunchConditionCheck();
    }

    /**
     * Create an instance of {@link CreateOutageWindowResponse }
     * 
     */
    public CreateOutageWindowResponse createCreateOutageWindowResponse() {
        return new CreateOutageWindowResponse();
    }

    /**
     * Create an instance of {@link AddLaunchResponse }
     * 
     */
    public AddLaunchResponse createAddLaunchResponse() {
        return new AddLaunchResponse();
    }

    /**
     * Create an instance of {@link RunNoteFilter }
     * 
     */
    public RunNoteFilter createRunNoteFilter() {
        return new RunNoteFilter();
    }

    /**
     * Create an instance of {@link Engine }
     * 
     */
    public Engine createEngine() {
        return new Engine();
    }

    /**
     * Create an instance of {@link DisableLaunchResponse }
     * 
     */
    public DisableLaunchResponse createDisableLaunchResponse() {
        return new DisableLaunchResponse();
    }

    /**
     * Create an instance of {@link GetListMU }
     * 
     */
    public GetListMU createGetListMU() {
        return new GetListMU();
    }

    /**
     * Create an instance of {@link GetPreviousLaunchesResponse }
     * 
     */
    public GetPreviousLaunchesResponse createGetPreviousLaunchesResponse() {
        return new GetPreviousLaunchesResponse();
    }

    /**
     * Create an instance of {@link NodeItem }
     * 
     */
    public NodeItem createNodeItem() {
        return new NodeItem();
    }

    /**
     * Create an instance of {@link DeleteEventResponse }
     * 
     */
    public DeleteEventResponse createDeleteEventResponse() {
        return new DeleteEventResponse();
    }

    /**
     * Create an instance of {@link DuwsVersion }
     * 
     */
    public DuwsVersion createDuwsVersion() {
        return new DuwsVersion();
    }

    /**
     * Create an instance of {@link GetListLaunch }
     * 
     */
    public GetListLaunch createGetListLaunch() {
        return new GetListLaunch();
    }

    /**
     * Create an instance of {@link GetRunNotes }
     * 
     */
    public GetRunNotes createGetRunNotes() {
        return new GetRunNotes();
    }

    /**
     * Create an instance of {@link OutageWindow }
     * 
     */
    public OutageWindow createOutageWindow() {
        return new OutageWindow();
    }

    /**
     * Create an instance of {@link RerunExecutionResponse }
     * 
     */
    public RerunExecutionResponse createRerunExecutionResponse() {
        return new RerunExecutionResponse();
    }

    /**
     * Create an instance of {@link GetHistoryTrace }
     * 
     */
    public GetHistoryTrace createGetHistoryTrace() {
        return new GetHistoryTrace();
    }

    /**
     * Create an instance of {@link UnacknowledgeExecutionResponse }
     * 
     */
    public UnacknowledgeExecutionResponse createUnacknowledgeExecutionResponse() {
        return new UnacknowledgeExecutionResponse();
    }

    /**
     * Create an instance of {@link UvmsNodeFilter }
     * 
     */
    public UvmsNodeFilter createUvmsNodeFilter() {
        return new UvmsNodeFilter();
    }

    /**
     * Create an instance of {@link GetExecutionLog }
     * 
     */
    public GetExecutionLog createGetExecutionLog() {
        return new GetExecutionLog();
    }

    /**
     * Create an instance of {@link LaunchItem }
     * 
     */
    public LaunchItem createLaunchItem() {
        return new LaunchItem();
    }

    /**
     * Create an instance of {@link GetRunBooksResponse }
     * 
     */
    public GetRunBooksResponse createGetRunBooksResponse() {
        return new GetRunBooksResponse();
    }

    /**
     * Create an instance of {@link GetListEvent }
     * 
     */
    public GetListEvent createGetListEvent() {
        return new GetListEvent();
    }

    /**
     * Create an instance of {@link GetRunBookExternalFileResponse }
     * 
     */
    public GetRunBookExternalFileResponse createGetRunBookExternalFileResponse() {
        return new GetRunBookExternalFileResponse();
    }

    /**
     * Create an instance of {@link GetRunNotesResponse }
     * 
     */
    public GetRunNotesResponse createGetRunNotesResponse() {
        return new GetRunNotesResponse();
    }

    /**
     * Create an instance of {@link AddEventResponse }
     * 
     */
    public AddEventResponse createAddEventResponse() {
        return new AddEventResponse();
    }

    /**
     * Create an instance of {@link ResetQueueResponse }
     * 
     */
    public ResetQueueResponse createResetQueueResponse() {
        return new ResetQueueResponse();
    }

    /**
     * Create an instance of {@link Variable }
     * 
     */
    public Variable createVariable() {
        return new Variable();
    }

    /**
     * Create an instance of {@link HoldLaunch }
     * 
     */
    public HoldLaunch createHoldLaunch() {
        return new HoldLaunch();
    }

    /**
     * Create an instance of {@link AddLaunchFromTask }
     * 
     */
    public AddLaunchFromTask createAddLaunchFromTask() {
        return new AddLaunchFromTask();
    }

    /**
     * Create an instance of {@link SessionTree }
     * 
     */
    public SessionTree createSessionTree() {
        return new SessionTree();
    }

    /**
     * Create an instance of {@link DeleteLaunchResponse }
     * 
     */
    public DeleteLaunchResponse createDeleteLaunchResponse() {
        return new DeleteLaunchResponse();
    }

    /**
     * Create an instance of {@link UprocId }
     * 
     */
    public UprocId createUprocId() {
        return new UprocId();
    }

    /**
     * Create an instance of {@link Envir }
     * 
     */
    public Envir createEnvir() {
        return new Envir();
    }

    /**
     * Create an instance of {@link Context }
     * 
     */
    public Context createContext() {
        return new Context();
    }

    /**
     * Create an instance of {@link SessionId }
     * 
     */
    public SessionId createSessionId() {
        return new SessionId();
    }

    /**
     * Create an instance of {@link EventId }
     * 
     */
    public EventId createEventId() {
        return new EventId();
    }

    /**
     * Create an instance of {@link ExecutionId }
     * 
     */
    public ExecutionId createExecutionId() {
        return new ExecutionId();
    }

    /**
     * Create an instance of {@link NodeId }
     * 
     */
    public NodeId createNodeId() {
        return new NodeId();
    }

    /**
     * Create an instance of {@link MuId }
     * 
     */
    public MuId createMuId() {
        return new MuId();
    }

    /**
     * Create an instance of {@link TaskId }
     * 
     */
    public TaskId createTaskId() {
        return new TaskId();
    }

    /**
     * Create an instance of {@link Execution.Variables }
     * 
     */
    public Execution.Variables createExecutionVariables() {
        return new Execution.Variables();
    }

    /**
     * Create an instance of {@link Launch.Variables }
     * 
     */
    public Launch.Variables createLaunchVariables() {
        return new Launch.Variables();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExecution }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getExecution")
    public JAXBElement<GetExecution> createGetExecution(GetExecution value) {
        return new JAXBElement<GetExecution>(_GetExecution_QNAME, GetExecution.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopQueueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "stopQueueResponse")
    public JAXBElement<StopQueueResponse> createStopQueueResponse(StopQueueResponse value) {
        return new JAXBElement<StopQueueResponse>(_StopQueueResponse_QNAME, StopQueueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLaunchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getLaunchResponse")
    public JAXBElement<GetLaunchResponse> createGetLaunchResponse(GetLaunchResponse value) {
        return new JAXBElement<GetLaunchResponse>(_GetLaunchResponse_QNAME, GetLaunchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOutageWindow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "createOutageWindow")
    public JAXBElement<CreateOutageWindow> createCreateOutageWindow(CreateOutageWindow value) {
        return new JAXBElement<CreateOutageWindow>(_CreateOutageWindow_QNAME, CreateOutageWindow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLaunchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "updateLaunchResponse")
    public JAXBElement<UpdateLaunchResponse> createUpdateLaunchResponse(UpdateLaunchResponse value) {
        return new JAXBElement<UpdateLaunchResponse>(_UpdateLaunchResponse_QNAME, UpdateLaunchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLaunchFromTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getLaunchFromTaskResponse")
    public JAXBElement<GetLaunchFromTaskResponse> createGetLaunchFromTaskResponse(GetLaunchFromTaskResponse value) {
        return new JAXBElement<GetLaunchFromTaskResponse>(_GetLaunchFromTaskResponse_QNAME, GetLaunchFromTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "eventItem")
    public JAXBElement<EventItem> createEventItem(EventItem value) {
        return new JAXBElement<EventItem>(_EventItem_QNAME, EventItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getEventResponse")
    public JAXBElement<GetEventResponse> createGetEventResponse(GetEventResponse value) {
        return new JAXBElement<GetEventResponse>(_GetEventResponse_QNAME, GetEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListEventResponse")
    public JAXBElement<GetListEventResponse> createGetListEventResponse(GetListEventResponse value) {
        return new JAXBElement<GetListEventResponse>(_GetListEventResponse_QNAME, GetListEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SessionFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "sessionFilter")
    public JAXBElement<SessionFilter> createSessionFilter(SessionFilter value) {
        return new JAXBElement<SessionFilter>(_SessionFilter_QNAME, SessionFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SessionNode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "sessionNode")
    public JAXBElement<SessionNode> createSessionNode(SessionNode value) {
        return new JAXBElement<SessionNode>(_SessionNode_QNAME, SessionNode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "deleteEvent")
    public JAXBElement<DeleteEvent> createDeleteEvent(DeleteEvent value) {
        return new JAXBElement<DeleteEvent>(_DeleteEvent_QNAME, DeleteEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PurgeExecutionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "purgeExecutionResponse")
    public JAXBElement<PurgeExecutionResponse> createPurgeExecutionResponse(PurgeExecutionResponse value) {
        return new JAXBElement<PurgeExecutionResponse>(_PurgeExecutionResponse_QNAME, PurgeExecutionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListOutage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListOutage")
    public JAXBElement<GetListOutage> createGetListOutage(GetListOutage value) {
        return new JAXBElement<GetListOutage>(_GetListOutage_QNAME, GetListOutage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunBookFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "runBookFilter")
    public JAXBElement<RunBookFilter> createRunBookFilter(RunBookFilter value) {
        return new JAXBElement<RunBookFilter>(_RunBookFilter_QNAME, RunBookFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopExecution }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "stopExecution")
    public JAXBElement<StopExecution> createStopExecution(StopExecution value) {
        return new JAXBElement<StopExecution>(_StopExecution_QNAME, StopExecution.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "eventFilter")
    public JAXBElement<EventFilter> createEventFilter(EventFilter value) {
        return new JAXBElement<EventFilter>(_EventFilter_QNAME, EventFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLaunch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "updateLaunch")
    public JAXBElement<UpdateLaunch> createUpdateLaunch(UpdateLaunch value) {
        return new JAXBElement<UpdateLaunch>(_UpdateLaunch_QNAME, UpdateLaunch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListSession")
    public JAXBElement<GetListSession> createGetListSession(GetListSession value) {
        return new JAXBElement<GetListSession>(_GetListSession_QNAME, GetListSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExecutionLogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getExecutionLogResponse")
    public JAXBElement<GetExecutionLogResponse> createGetExecutionLogResponse(GetExecutionLogResponse value) {
        return new JAXBElement<GetExecutionLogResponse>(_GetExecutionLogResponse_QNAME, GetExecutionLogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SkipExecution }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "skipExecution")
    public JAXBElement<SkipExecution> createSkipExecution(SkipExecution value) {
        return new JAXBElement<SkipExecution>(_SkipExecution_QNAME, SkipExecution.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExecutionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getExecutionResponse")
    public JAXBElement<GetExecutionResponse> createGetExecutionResponse(GetExecutionResponse value) {
        return new JAXBElement<GetExecutionResponse>(_GetExecutionResponse_QNAME, GetExecutionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWsVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getWsVersion")
    public JAXBElement<GetWsVersion> createGetWsVersion(GetWsVersion value) {
        return new JAXBElement<GetWsVersion>(_GetWsVersion_QNAME, GetWsVersion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOutageWindow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "deleteOutageWindow")
    public JAXBElement<DeleteOutageWindow> createDeleteOutageWindow(DeleteOutageWindow value) {
        return new JAXBElement<DeleteOutageWindow>(_DeleteOutageWindow_QNAME, DeleteOutageWindow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SkipExecutionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "skipExecutionResponse")
    public JAXBElement<SkipExecutionResponse> createSkipExecutionResponse(SkipExecutionResponse value) {
        return new JAXBElement<SkipExecutionResponse>(_SkipExecutionResponse_QNAME, SkipExecutionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "updateEvent")
    public JAXBElement<UpdateEvent> createUpdateEvent(UpdateEvent value) {
        return new JAXBElement<UpdateEvent>(_UpdateEvent_QNAME, UpdateEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UvmsContext }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "uvmsContext")
    public JAXBElement<UvmsContext> createUvmsContext(UvmsContext value) {
        return new JAXBElement<UvmsContext>(_UvmsContext_QNAME, UvmsContext.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LaunchId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "launchId")
    public JAXBElement<LaunchId> createLaunchId(LaunchId value) {
        return new JAXBElement<LaunchId>(_LaunchId_QNAME, LaunchId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExecutionLogAsAttachmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getExecutionLogAsAttachmentResponse")
    public JAXBElement<GetExecutionLogAsAttachmentResponse> createGetExecutionLogAsAttachmentResponse(GetExecutionLogAsAttachmentResponse value) {
        return new JAXBElement<GetExecutionLogAsAttachmentResponse>(_GetExecutionLogAsAttachmentResponse_QNAME, GetExecutionLogAsAttachmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListNode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListNode")
    public JAXBElement<GetListNode> createGetListNode(GetListNode value) {
        return new JAXBElement<GetListNode>(_GetListNode_QNAME, GetListNode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLaunchFromTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getLaunchFromTask")
    public JAXBElement<GetLaunchFromTask> createGetLaunchFromTask(GetLaunchFromTask value) {
        return new JAXBElement<GetLaunchFromTask>(_GetLaunchFromTask_QNAME, GetLaunchFromTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestartEngineResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "restartEngineResponse")
    public JAXBElement<RestartEngineResponse> createRestartEngineResponse(RestartEngineResponse value) {
        return new JAXBElement<RestartEngineResponse>(_RestartEngineResponse_QNAME, RestartEngineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSessionTreeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getSessionTreeResponse")
    public JAXBElement<GetSessionTreeResponse> createGetSessionTreeResponse(GetSessionTreeResponse value) {
        return new JAXBElement<GetSessionTreeResponse>(_GetSessionTreeResponse_QNAME, GetSessionTreeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "runBook")
    public JAXBElement<RunBook> createRunBook(RunBook value) {
        return new JAXBElement<RunBook>(_RunBook_QNAME, RunBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResetQueue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "resetQueue")
    public JAXBElement<ResetQueue> createResetQueue(ResetQueue value) {
        return new JAXBElement<ResetQueue>(_ResetQueue_QNAME, ResetQueue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOutageWindowResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "deleteOutageWindowResponse")
    public JAXBElement<DeleteOutageWindowResponse> createDeleteOutageWindowResponse(DeleteOutageWindowResponse value) {
        return new JAXBElement<DeleteOutageWindowResponse>(_DeleteOutageWindowResponse_QNAME, DeleteOutageWindowResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListUprocResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListUprocResponse")
    public JAXBElement<GetListUprocResponse> createGetListUprocResponse(GetListUprocResponse value) {
        return new JAXBElement<GetListUprocResponse>(_GetListUprocResponse_QNAME, GetListUprocResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopQueue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "stopQueue")
    public JAXBElement<StopQueue> createStopQueue(StopQueue value) {
        return new JAXBElement<StopQueue>(_StopQueue_QNAME, StopQueue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MuItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "muItem")
    public JAXBElement<MuItem> createMuItem(MuItem value) {
        return new JAXBElement<MuItem>(_MuItem_QNAME, MuItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcknowledgeExecutionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "acknowledgeExecutionResponse")
    public JAXBElement<AcknowledgeExecutionResponse> createAcknowledgeExecutionResponse(AcknowledgeExecutionResponse value) {
        return new JAXBElement<AcknowledgeExecutionResponse>(_AcknowledgeExecutionResponse_QNAME, AcknowledgeExecutionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutageFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "outageFilter")
    public JAXBElement<OutageFilter> createOutageFilter(OutageFilter value) {
        return new JAXBElement<OutageFilter>(_OutageFilter_QNAME, OutageFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDUEnvironmentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getDUEnvironmentList")
    public JAXBElement<GetDUEnvironmentList> createGetDUEnvironmentList(GetDUEnvironmentList value) {
        return new JAXBElement<GetDUEnvironmentList>(_GetDUEnvironmentList_QNAME, GetDUEnvironmentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HoldLaunchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "holdLaunchResponse")
    public JAXBElement<HoldLaunchResponse> createHoldLaunchResponse(HoldLaunchResponse value) {
        return new JAXBElement<HoldLaunchResponse>(_HoldLaunchResponse_QNAME, HoldLaunchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Event }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "event")
    public JAXBElement<Event> createEvent(Event value) {
        return new JAXBElement<Event>(_Event_QNAME, Event.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisableLaunch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "disableLaunch")
    public JAXBElement<DisableLaunch> createDisableLaunch(DisableLaunch value) {
        return new JAXBElement<DisableLaunch>(_DisableLaunch_QNAME, DisableLaunch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnableLaunchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "enableLaunchResponse")
    public JAXBElement<EnableLaunchResponse> createEnableLaunchResponse(EnableLaunchResponse value) {
        return new JAXBElement<EnableLaunchResponse>(_EnableLaunchResponse_QNAME, EnableLaunchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExecutionLogAsAttachment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getExecutionLogAsAttachment")
    public JAXBElement<GetExecutionLogAsAttachment> createGetExecutionLogAsAttachment(GetExecutionLogAsAttachment value) {
        return new JAXBElement<GetExecutionLogAsAttachment>(_GetExecutionLogAsAttachment_QNAME, GetExecutionLogAsAttachment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLaunch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getLaunch")
    public JAXBElement<GetLaunch> createGetLaunch(GetLaunch value) {
        return new JAXBElement<GetLaunch>(_GetLaunch_QNAME, GetLaunch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaskFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "taskFilter")
    public JAXBElement<TaskFilter> createTaskFilter(TaskFilter value) {
        return new JAXBElement<TaskFilter>(_TaskFilter_QNAME, TaskFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListTaskResponse")
    public JAXBElement<GetListTaskResponse> createGetListTaskResponse(GetListTaskResponse value) {
        return new JAXBElement<GetListTaskResponse>(_GetListTaskResponse_QNAME, GetListTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnableLaunch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "enableLaunch")
    public JAXBElement<EnableLaunch> createEnableLaunch(EnableLaunch value) {
        return new JAXBElement<EnableLaunch>(_EnableLaunch_QNAME, EnableLaunch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScriptResourceLogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getScriptResourceLogResponse")
    public JAXBElement<GetScriptResourceLogResponse> createGetScriptResourceLogResponse(GetScriptResourceLogResponse value) {
        return new JAXBElement<GetScriptResourceLogResponse>(_GetScriptResourceLogResponse_QNAME, GetScriptResourceLogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSessionTree }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getSessionTree")
    public JAXBElement<GetSessionTree> createGetSessionTree(GetSessionTree value) {
        return new JAXBElement<GetSessionTree>(_GetSessionTree_QNAME, GetSessionTree.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HistoryTrace }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "historyTrace")
    public JAXBElement<HistoryTrace> createHistoryTrace(HistoryTrace value) {
        return new JAXBElement<HistoryTrace>(_HistoryTrace_QNAME, HistoryTrace.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SessionItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "sessionItem")
    public JAXBElement<SessionItem> createSessionItem(SessionItem value) {
        return new JAXBElement<SessionItem>(_SessionItem_QNAME, SessionItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Launch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "launch")
    public JAXBElement<Launch> createLaunch(Launch value) {
        return new JAXBElement<Launch>(_Launch_QNAME, Launch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRunBookExternalFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getRunBookExternalFile")
    public JAXBElement<GetRunBookExternalFile> createGetRunBookExternalFile(GetRunBookExternalFile value) {
        return new JAXBElement<GetRunBookExternalFile>(_GetRunBookExternalFile_QNAME, GetRunBookExternalFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReleaseLaunchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "releaseLaunchResponse")
    public JAXBElement<ReleaseLaunchResponse> createReleaseLaunchResponse(ReleaseLaunchResponse value) {
        return new JAXBElement<ReleaseLaunchResponse>(_ReleaseLaunchResponse_QNAME, ReleaseLaunchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NodeFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "nodeFilter")
    public JAXBElement<NodeFilter> createNodeFilter(NodeFilter value) {
        return new JAXBElement<NodeFilter>(_NodeFilter_QNAME, NodeFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListLaunchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListLaunchResponse")
    public JAXBElement<GetListLaunchResponse> createGetListLaunchResponse(GetListLaunchResponse value) {
        return new JAXBElement<GetListLaunchResponse>(_GetListLaunchResponse_QNAME, GetListLaunchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContextHolder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "contextHolder")
    public JAXBElement<ContextHolder> createContextHolder(ContextHolder value) {
        return new JAXBElement<ContextHolder>(_ContextHolder_QNAME, ContextHolder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListExecutionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListExecutionResponse")
    public JAXBElement<GetListExecutionResponse> createGetListExecutionResponse(GetListExecutionResponse value) {
        return new JAXBElement<GetListExecutionResponse>(_GetListExecutionResponse_QNAME, GetListExecutionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ForceCompleteLaunch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "forceCompleteLaunch")
    public JAXBElement<ForceCompleteLaunch> createForceCompleteLaunch(ForceCompleteLaunch value) {
        return new JAXBElement<ForceCompleteLaunch>(_ForceCompleteLaunch_QNAME, ForceCompleteLaunch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Queue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "queue")
    public JAXBElement<Queue> createQueue(Queue value) {
        return new JAXBElement<Queue>(_Queue_QNAME, Queue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecutionLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "executionLog")
    public JAXBElement<ExecutionLog> createExecutionLog(ExecutionLog value) {
        return new JAXBElement<ExecutionLog>(_ExecutionLog_QNAME, ExecutionLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListUproc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListUproc")
    public JAXBElement<GetListUproc> createGetListUproc(GetListUproc value) {
        return new JAXBElement<GetListUproc>(_GetListUproc_QNAME, GetListUproc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "updateEventResponse")
    public JAXBElement<UpdateEventResponse> createUpdateEventResponse(UpdateEventResponse value) {
        return new JAXBElement<UpdateEventResponse>(_UpdateEventResponse_QNAME, UpdateEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopEngineResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "stopEngineResponse")
    public JAXBElement<StopEngineResponse> createStopEngineResponse(StopEngineResponse value) {
        return new JAXBElement<StopEngineResponse>(_StopEngineResponse_QNAME, StopEngineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunNote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "runNote")
    public JAXBElement<RunNote> createRunNote(RunNote value) {
        return new JAXBElement<RunNote>(_RunNote_QNAME, RunNote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListSessionResponse")
    public JAXBElement<GetListSessionResponse> createGetListSessionResponse(GetListSessionResponse value) {
        return new JAXBElement<GetListSessionResponse>(_GetListSessionResponse_QNAME, GetListSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDUEnvironmentListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getDUEnvironmentListResponse")
    public JAXBElement<GetDUEnvironmentListResponse> createGetDUEnvironmentListResponse(GetDUEnvironmentListResponse value) {
        return new JAXBElement<GetDUEnvironmentListResponse>(_GetDUEnvironmentListResponse_QNAME, GetDUEnvironmentListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListNodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListNodeResponse")
    public JAXBElement<GetListNodeResponse> createGetListNodeResponse(GetListNodeResponse value) {
        return new JAXBElement<GetListNodeResponse>(_GetListNodeResponse_QNAME, GetListNodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SessionTimedOutException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "SessionTimedOutException")
    public JAXBElement<SessionTimedOutException> createSessionTimedOutException(SessionTimedOutException value) {
        return new JAXBElement<SessionTimedOutException>(_SessionTimedOutException_QNAME, SessionTimedOutException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecutionFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "executionFilter")
    public JAXBElement<ExecutionFilter> createExecutionFilter(ExecutionFilter value) {
        return new JAXBElement<ExecutionFilter>(_ExecutionFilter_QNAME, ExecutionFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartEngineResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "startEngineResponse")
    public JAXBElement<StartEngineResponse> createStartEngineResponse(StartEngineResponse value) {
        return new JAXBElement<StartEngineResponse>(_StartEngineResponse_QNAME, StartEngineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getEvent")
    public JAXBElement<GetEvent> createGetEvent(GetEvent value) {
        return new JAXBElement<GetEvent>(_GetEvent_QNAME, GetEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DuwsException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "DuwsException")
    public JAXBElement<DuwsException> createDuwsException(DuwsException value) {
        return new JAXBElement<DuwsException>(_DuwsException_QNAME, DuwsException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLaunchFromTask2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "addLaunchFromTask2")
    public JAXBElement<AddLaunchFromTask2> createAddLaunchFromTask2(AddLaunchFromTask2 value) {
        return new JAXBElement<AddLaunchFromTask2>(_AddLaunchFromTask2_QNAME, AddLaunchFromTask2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLaunch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "deleteLaunch")
    public JAXBElement<DeleteLaunch> createDeleteLaunch(DeleteLaunch value) {
        return new JAXBElement<DeleteLaunch>(_DeleteLaunch_QNAME, DeleteLaunch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BypassLaunchConditionCheckResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "bypassLaunchConditionCheckResponse")
    public JAXBElement<BypassLaunchConditionCheckResponse> createBypassLaunchConditionCheckResponse(BypassLaunchConditionCheckResponse value) {
        return new JAXBElement<BypassLaunchConditionCheckResponse>(_BypassLaunchConditionCheckResponse_QNAME, BypassLaunchConditionCheckResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListExecution }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListExecution")
    public JAXBElement<GetListExecution> createGetListExecution(GetListExecution value) {
        return new JAXBElement<GetListExecution>(_GetListExecution_QNAME, GetListExecution.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReleaseLaunch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "releaseLaunch")
    public JAXBElement<ReleaseLaunch> createReleaseLaunch(ReleaseLaunch value) {
        return new JAXBElement<ReleaseLaunch>(_ReleaseLaunch_QNAME, ReleaseLaunch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LaunchFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "launchFilter")
    public JAXBElement<LaunchFilter> createLaunchFilter(LaunchFilter value) {
        return new JAXBElement<LaunchFilter>(_LaunchFilter_QNAME, LaunchFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ForceCompleteLaunchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "forceCompleteLaunchResponse")
    public JAXBElement<ForceCompleteLaunchResponse> createForceCompleteLaunchResponse(ForceCompleteLaunchResponse value) {
        return new JAXBElement<ForceCompleteLaunchResponse>(_ForceCompleteLaunchResponse_QNAME, ForceCompleteLaunchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "addEvent")
    public JAXBElement<AddEvent> createAddEvent(AddEvent value) {
        return new JAXBElement<AddEvent>(_AddEvent_QNAME, AddEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RerunExecution }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "rerunExecution")
    public JAXBElement<RerunExecution> createRerunExecution(RerunExecution value) {
        return new JAXBElement<RerunExecution>(_RerunExecution_QNAME, RerunExecution.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UprocFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "uprocFilter")
    public JAXBElement<UprocFilter> createUprocFilter(UprocFilter value) {
        return new JAXBElement<UprocFilter>(_UprocFilter_QNAME, UprocFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistoryTraceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getHistoryTraceResponse")
    public JAXBElement<GetHistoryTraceResponse> createGetHistoryTraceResponse(GetHistoryTraceResponse value) {
        return new JAXBElement<GetHistoryTraceResponse>(_GetHistoryTraceResponse_QNAME, GetHistoryTraceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListOutageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListOutageResponse")
    public JAXBElement<GetListOutageResponse> createGetListOutageResponse(GetListOutageResponse value) {
        return new JAXBElement<GetListOutageResponse>(_GetListOutageResponse_QNAME, GetListOutageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcknowledgeExecution }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "acknowledgeExecution")
    public JAXBElement<AcknowledgeExecution> createAcknowledgeExecution(AcknowledgeExecution value) {
        return new JAXBElement<AcknowledgeExecution>(_AcknowledgeExecution_QNAME, AcknowledgeExecution.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLaunchFromTask2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "addLaunchFromTask2Response")
    public JAXBElement<AddLaunchFromTask2Response> createAddLaunchFromTask2Response(AddLaunchFromTask2Response value) {
        return new JAXBElement<AddLaunchFromTask2Response>(_AddLaunchFromTask2Response_QNAME, AddLaunchFromTask2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnacknowledgeExecution }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "unacknowledgeExecution")
    public JAXBElement<UnacknowledgeExecution> createUnacknowledgeExecution(UnacknowledgeExecution value) {
        return new JAXBElement<UnacknowledgeExecution>(_UnacknowledgeExecution_QNAME, UnacknowledgeExecution.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLaunch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "addLaunch")
    public JAXBElement<AddLaunch> createAddLaunch(AddLaunch value) {
        return new JAXBElement<AddLaunch>(_AddLaunch_QNAME, AddLaunch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UprocItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "uprocItem")
    public JAXBElement<UprocItem> createUprocItem(UprocItem value) {
        return new JAXBElement<UprocItem>(_UprocItem_QNAME, UprocItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListMUResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListMUResponse")
    public JAXBElement<GetListMUResponse> createGetListMUResponse(GetListMUResponse value) {
        return new JAXBElement<GetListMUResponse>(_GetListMUResponse_QNAME, GetListMUResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWsVersionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getWsVersionResponse")
    public JAXBElement<GetWsVersionResponse> createGetWsVersionResponse(GetWsVersionResponse value) {
        return new JAXBElement<GetWsVersionResponse>(_GetWsVersionResponse_QNAME, GetWsVersionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopExecutionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "stopExecutionResponse")
    public JAXBElement<StopExecutionResponse> createStopExecutionResponse(StopExecutionResponse value) {
        return new JAXBElement<StopExecutionResponse>(_StopExecutionResponse_QNAME, StopExecutionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLaunchFromTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "addLaunchFromTaskResponse")
    public JAXBElement<AddLaunchFromTaskResponse> createAddLaunchFromTaskResponse(AddLaunchFromTaskResponse value) {
        return new JAXBElement<AddLaunchFromTaskResponse>(_AddLaunchFromTaskResponse_QNAME, AddLaunchFromTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListTask")
    public JAXBElement<GetListTask> createGetListTask(GetListTask value) {
        return new JAXBElement<GetListTask>(_GetListTask_QNAME, GetListTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaskItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "taskItem")
    public JAXBElement<TaskItem> createTaskItem(TaskItem value) {
        return new JAXBElement<TaskItem>(_TaskItem_QNAME, TaskItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRunBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getRunBooks")
    public JAXBElement<GetRunBooks> createGetRunBooks(GetRunBooks value) {
        return new JAXBElement<GetRunBooks>(_GetRunBooks_QNAME, GetRunBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPreviousLaunches }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getPreviousLaunches")
    public JAXBElement<GetPreviousLaunches> createGetPreviousLaunches(GetPreviousLaunches value) {
        return new JAXBElement<GetPreviousLaunches>(_GetPreviousLaunches_QNAME, GetPreviousLaunches.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScriptResourceLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getScriptResourceLog")
    public JAXBElement<GetScriptResourceLog> createGetScriptResourceLog(GetScriptResourceLog value) {
        return new JAXBElement<GetScriptResourceLog>(_GetScriptResourceLog_QNAME, GetScriptResourceLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopEngine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "stopEngine")
    public JAXBElement<StopEngine> createStopEngine(StopEngine value) {
        return new JAXBElement<StopEngine>(_StopEngine_QNAME, StopEngine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecutionItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "executionItem")
    public JAXBElement<ExecutionItem> createExecutionItem(ExecutionItem value) {
        return new JAXBElement<ExecutionItem>(_ExecutionItem_QNAME, ExecutionItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartQueue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "startQueue")
    public JAXBElement<StartQueue> createStartQueue(StartQueue value) {
        return new JAXBElement<StartQueue>(_StartQueue_QNAME, StartQueue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MuFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "muFilter")
    public JAXBElement<MuFilter> createMuFilter(MuFilter value) {
        return new JAXBElement<MuFilter>(_MuFilter_QNAME, MuFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestartEngine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "restartEngine")
    public JAXBElement<RestartEngine> createRestartEngine(RestartEngine value) {
        return new JAXBElement<RestartEngine>(_RestartEngine_QNAME, RestartEngine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PurgeExecution }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "purgeExecution")
    public JAXBElement<PurgeExecution> createPurgeExecution(PurgeExecution value) {
        return new JAXBElement<PurgeExecution>(_PurgeExecution_QNAME, PurgeExecution.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResourceLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "resourceLog")
    public JAXBElement<ResourceLog> createResourceLog(ResourceLog value) {
        return new JAXBElement<ResourceLog>(_ResourceLog_QNAME, ResourceLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartEngine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "startEngine")
    public JAXBElement<StartEngine> createStartEngine(StartEngine value) {
        return new JAXBElement<StartEngine>(_StartEngine_QNAME, StartEngine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BypassLaunchConditionCheck }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "bypassLaunchConditionCheck")
    public JAXBElement<BypassLaunchConditionCheck> createBypassLaunchConditionCheck(BypassLaunchConditionCheck value) {
        return new JAXBElement<BypassLaunchConditionCheck>(_BypassLaunchConditionCheck_QNAME, BypassLaunchConditionCheck.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOutageWindowResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "createOutageWindowResponse")
    public JAXBElement<CreateOutageWindowResponse> createCreateOutageWindowResponse(CreateOutageWindowResponse value) {
        return new JAXBElement<CreateOutageWindowResponse>(_CreateOutageWindowResponse_QNAME, CreateOutageWindowResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartQueueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "startQueueResponse")
    public JAXBElement<StartQueueResponse> createStartQueueResponse(StartQueueResponse value) {
        return new JAXBElement<StartQueueResponse>(_StartQueueResponse_QNAME, StartQueueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PreviousLaunch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "previousLaunch")
    public JAXBElement<PreviousLaunch> createPreviousLaunch(PreviousLaunch value) {
        return new JAXBElement<PreviousLaunch>(_PreviousLaunch_QNAME, PreviousLaunch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisableLaunchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "disableLaunchResponse")
    public JAXBElement<DisableLaunchResponse> createDisableLaunchResponse(DisableLaunchResponse value) {
        return new JAXBElement<DisableLaunchResponse>(_DisableLaunchResponse_QNAME, DisableLaunchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Engine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "engine")
    public JAXBElement<Engine> createEngine(Engine value) {
        return new JAXBElement<Engine>(_Engine_QNAME, Engine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunNoteFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "runNoteFilter")
    public JAXBElement<RunNoteFilter> createRunNoteFilter(RunNoteFilter value) {
        return new JAXBElement<RunNoteFilter>(_RunNoteFilter_QNAME, RunNoteFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLaunchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "addLaunchResponse")
    public JAXBElement<AddLaunchResponse> createAddLaunchResponse(AddLaunchResponse value) {
        return new JAXBElement<AddLaunchResponse>(_AddLaunchResponse_QNAME, AddLaunchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPreviousLaunchesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getPreviousLaunchesResponse")
    public JAXBElement<GetPreviousLaunchesResponse> createGetPreviousLaunchesResponse(GetPreviousLaunchesResponse value) {
        return new JAXBElement<GetPreviousLaunchesResponse>(_GetPreviousLaunchesResponse_QNAME, GetPreviousLaunchesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NodeItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "nodeItem")
    public JAXBElement<NodeItem> createNodeItem(NodeItem value) {
        return new JAXBElement<NodeItem>(_NodeItem_QNAME, NodeItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "deleteEventResponse")
    public JAXBElement<DeleteEventResponse> createDeleteEventResponse(DeleteEventResponse value) {
        return new JAXBElement<DeleteEventResponse>(_DeleteEventResponse_QNAME, DeleteEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListMU }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListMU")
    public JAXBElement<GetListMU> createGetListMU(GetListMU value) {
        return new JAXBElement<GetListMU>(_GetListMU_QNAME, GetListMU.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UvmsNodeFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "uvmsNodeFilter")
    public JAXBElement<UvmsNodeFilter> createUvmsNodeFilter(UvmsNodeFilter value) {
        return new JAXBElement<UvmsNodeFilter>(_UvmsNodeFilter_QNAME, UvmsNodeFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExecutionLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getExecutionLog")
    public JAXBElement<GetExecutionLog> createGetExecutionLog(GetExecutionLog value) {
        return new JAXBElement<GetExecutionLog>(_GetExecutionLog_QNAME, GetExecutionLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistoryTrace }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getHistoryTrace")
    public JAXBElement<GetHistoryTrace> createGetHistoryTrace(GetHistoryTrace value) {
        return new JAXBElement<GetHistoryTrace>(_GetHistoryTrace_QNAME, GetHistoryTrace.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnacknowledgeExecutionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "unacknowledgeExecutionResponse")
    public JAXBElement<UnacknowledgeExecutionResponse> createUnacknowledgeExecutionResponse(UnacknowledgeExecutionResponse value) {
        return new JAXBElement<UnacknowledgeExecutionResponse>(_UnacknowledgeExecutionResponse_QNAME, UnacknowledgeExecutionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RerunExecutionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "rerunExecutionResponse")
    public JAXBElement<RerunExecutionResponse> createRerunExecutionResponse(RerunExecutionResponse value) {
        return new JAXBElement<RerunExecutionResponse>(_RerunExecutionResponse_QNAME, RerunExecutionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DuwsVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "duwsVersion")
    public JAXBElement<DuwsVersion> createDuwsVersion(DuwsVersion value) {
        return new JAXBElement<DuwsVersion>(_DuwsVersion_QNAME, DuwsVersion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Execution }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "execution")
    public JAXBElement<Execution> createExecution(Execution value) {
        return new JAXBElement<Execution>(_Execution_QNAME, Execution.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListLaunch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListLaunch")
    public JAXBElement<GetListLaunch> createGetListLaunch(GetListLaunch value) {
        return new JAXBElement<GetListLaunch>(_GetListLaunch_QNAME, GetListLaunch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRunNotes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getRunNotes")
    public JAXBElement<GetRunNotes> createGetRunNotes(GetRunNotes value) {
        return new JAXBElement<GetRunNotes>(_GetRunNotes_QNAME, GetRunNotes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutageWindow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "outageWindow")
    public JAXBElement<OutageWindow> createOutageWindow(OutageWindow value) {
        return new JAXBElement<OutageWindow>(_OutageWindow_QNAME, OutageWindow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getListEvent")
    public JAXBElement<GetListEvent> createGetListEvent(GetListEvent value) {
        return new JAXBElement<GetListEvent>(_GetListEvent_QNAME, GetListEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRunBookExternalFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getRunBookExternalFileResponse")
    public JAXBElement<GetRunBookExternalFileResponse> createGetRunBookExternalFileResponse(GetRunBookExternalFileResponse value) {
        return new JAXBElement<GetRunBookExternalFileResponse>(_GetRunBookExternalFileResponse_QNAME, GetRunBookExternalFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRunBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getRunBooksResponse")
    public JAXBElement<GetRunBooksResponse> createGetRunBooksResponse(GetRunBooksResponse value) {
        return new JAXBElement<GetRunBooksResponse>(_GetRunBooksResponse_QNAME, GetRunBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LaunchItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "launchItem")
    public JAXBElement<LaunchItem> createLaunchItem(LaunchItem value) {
        return new JAXBElement<LaunchItem>(_LaunchItem_QNAME, LaunchItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "addEventResponse")
    public JAXBElement<AddEventResponse> createAddEventResponse(AddEventResponse value) {
        return new JAXBElement<AddEventResponse>(_AddEventResponse_QNAME, AddEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResetQueueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "resetQueueResponse")
    public JAXBElement<ResetQueueResponse> createResetQueueResponse(ResetQueueResponse value) {
        return new JAXBElement<ResetQueueResponse>(_ResetQueueResponse_QNAME, ResetQueueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRunNotesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "getRunNotesResponse")
    public JAXBElement<GetRunNotesResponse> createGetRunNotesResponse(GetRunNotesResponse value) {
        return new JAXBElement<GetRunNotesResponse>(_GetRunNotesResponse_QNAME, GetRunNotesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLaunchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "deleteLaunchResponse")
    public JAXBElement<DeleteLaunchResponse> createDeleteLaunchResponse(DeleteLaunchResponse value) {
        return new JAXBElement<DeleteLaunchResponse>(_DeleteLaunchResponse_QNAME, DeleteLaunchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HoldLaunch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "holdLaunch")
    public JAXBElement<HoldLaunch> createHoldLaunch(HoldLaunch value) {
        return new JAXBElement<HoldLaunch>(_HoldLaunch_QNAME, HoldLaunch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLaunchFromTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "addLaunchFromTask")
    public JAXBElement<AddLaunchFromTask> createAddLaunchFromTask(AddLaunchFromTask value) {
        return new JAXBElement<AddLaunchFromTask>(_AddLaunchFromTask_QNAME, AddLaunchFromTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SessionTree }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "sessionTree")
    public JAXBElement<SessionTree> createSessionTree(SessionTree value) {
        return new JAXBElement<SessionTree>(_SessionTree_QNAME, SessionTree.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Variable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "variable")
    public JAXBElement<Variable> createVariable(Variable value) {
        return new JAXBElement<Variable>(_Variable_QNAME, Variable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "sessionVersion", scope = ExecutionId.class)
    public JAXBElement<String> createExecutionIdSessionVersion(String value) {
        return new JAXBElement<String>(_ExecutionIdSessionVersion_QNAME, String.class, ExecutionId.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "mu", scope = ExecutionId.class)
    public JAXBElement<String> createExecutionIdMu(String value) {
        return new JAXBElement<String>(_ExecutionIdMu_QNAME, String.class, ExecutionId.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "area", scope = Envir.class)
    public JAXBElement<String> createEnvirArea(String value) {
        return new JAXBElement<String>(_EnvirArea_QNAME, String.class, Envir.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnvirStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "status", scope = Envir.class)
    public JAXBElement<EnvirStatus> createEnvirStatus(EnvirStatus value) {
        return new JAXBElement<EnvirStatus>(_EnvirStatus_QNAME, EnvirStatus.class, Envir.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://duws.orsyp.com", name = "version", scope = Envir.class)
    public JAXBElement<String> createEnvirVersion(String value) {
        return new JAXBElement<String>(_EnvirVersion_QNAME, String.class, Envir.class, value);
    }

}
