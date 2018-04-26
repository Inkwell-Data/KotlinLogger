package quanti.com.kotlinlog.file.file

import android.content.Context
import quanti.com.kotlinlog.file.base.FileLoggerBase
import java.io.File
import java.io.FileOutputStream

/**
 * Created by Trnka Vladislav on 11.09.2017.
 *
 * Base file for log files
 */

val TAG = "LogFile"

abstract class BaseLogFile(
        ctx: Context,
        val name: String,
        maxDaysSaved: Int = 3
) {

    private val file: File = File(ctx.filesDir, name)
    internal val fos: FileOutputStream = ctx.openFileOutput(name, Context.MODE_APPEND)

    init {
        if (quanti.com.kotlinlog.Log.DEBUG_LIBRARY){
            android.util.Log.i(TAG, "Creating new text file: " + file.absolutePath)
        }
        FileLoggerBase.removeAllOldTemps(ctx, maxDaysSaved)
    }

    fun getFileName() = name

    fun closeOutputStream() = fos.close()

    open fun write(string: String) {
        fos.write(string.toByteArray())
    }

    fun delete() {
        val del = file.delete()
        if (quanti.com.kotlinlog.Log.DEBUG_LIBRARY){
            android.util.Log.i(TAG, "File ${file.absolutePath} was deleted: $del")
        }
    }

}
