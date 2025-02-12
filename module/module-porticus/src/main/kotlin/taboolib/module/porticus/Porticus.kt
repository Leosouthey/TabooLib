package taboolib.module.porticus

import net.md_5.bungee.BungeeCord
import org.bukkit.Bukkit
import taboolib.common.Inject
import taboolib.common.LifeCycle
import taboolib.common.env.RuntimeDependency
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.platform.function.pluginId
import taboolib.common.util.unsafeLazy
import java.util.concurrent.CopyOnWriteArrayList

/**
 * Porticus API 通用入口
 *
 * @author 坏黑
 * @since 2020-10-15
 */
@Inject
@PlatformSide(Platform.BUKKIT, Platform.BUNGEE)
@RuntimeDependency("!com.google.guava:guava:21.0", test = "!com.google.common.base.Optional")
object Porticus {

    val channelId by unsafeLazy {
        "t_${if (pluginId.lowercase().length > 10) pluginId.lowercase().substring(0, 10) else pluginId.lowercase()}:main"
    }

    /**
     * 获取正在运行的通讯任务
     */
    val missions = CopyOnWriteArrayList<PorticusMission>()

    /**
     * 获取 Porticus API
     */
    lateinit var API: API
        private set

    /**
     * 因需要注册监听器，该方法不能在 onEnable 之前运行
     */
    @Awake(LifeCycle.ENABLE)
    private fun onEnable() {
        try {
            Bukkit.getServer()
            API = taboolib.module.porticus.bukkitside.PorticusAPI()
        } catch (ignored: NoClassDefFoundError) {
        }
        try {
            BungeeCord.getInstance()
            API = taboolib.module.porticus.bungeeside.PorticusAPI()
        } catch (ignored: NoClassDefFoundError) {
        }
    }
}