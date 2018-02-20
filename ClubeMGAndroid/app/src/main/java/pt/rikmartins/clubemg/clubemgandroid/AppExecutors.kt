package pt.rikmartins.clubemg.clubemgandroid

import android.os.Handler
import android.os.Looper

import java.util.concurrent.Executor

class AppExecutors(val diskIO: Executor, val mainThread: Executor, val networkIO: Executor) {

    class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}
