package top.niunaijun.blackboxa.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            try {
                val daemonIntent = Intent().apply {
                    setClassName(context.packageName, "top.niunaijun.blackbox.core.system.DaemonService")
                }
                context.startForegroundService(daemonIntent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
