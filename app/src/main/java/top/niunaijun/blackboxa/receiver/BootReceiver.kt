package top.niunaijun.blackboxa.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import top.niunaijun.blackboxa.BlackBoxApplication

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            // Restart core services after reboot
            val app = context.applicationContext
            // Start DaemonService
            try {
                val daemonIntent = Intent().apply {
                    setClassName(app.packageName, "top.niunaijun.blackbox.core.system.DaemonService")
                }
                context.startForegroundService(daemonIntent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
