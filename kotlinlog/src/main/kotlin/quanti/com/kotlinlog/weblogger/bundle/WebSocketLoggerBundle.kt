package quanti.com.kotlinlog.weblogger.bundle

import quanti.com.kotlinlog.base.LogLevel
import quanti.com.kotlinlog.utils.getRandomString
import quanti.com.kotlinlog.weblogger.rest.IServerActive

/**
 * Bundle class for WebLogger using WebSocket protocol
 *
 * @param url okhttp url address of the server - it has to start with 'ws://' and end with '/'
 * @param severActive callback to check if server is active
 * @param minimalLogLevel minimalLogLevel - default LogLevel.Verbose
 * @param minimalLogLevelThrowable minimal log level for calls with throwable - default LogLevel.Verbose
 * @param sessionName session name identificator on webserver
 */
class WebSocketLoggerBundle @JvmOverloads constructor(
        url: String,
        severActive: IServerActive = dummyIsServerActiveImplementation,
        minimalLogLevel: Int = LogLevel.VERBOSE,
        minimalLogLevelThrowable: Int = LogLevel.VERBOSE,
        sessionName: String = "KotlinLoggerSession_ws_" + getRandomString(4)
) : BaseWebLoggerBundle (
        url, severActive, minimalLogLevel, minimalLogLevelThrowable, sessionName
)
