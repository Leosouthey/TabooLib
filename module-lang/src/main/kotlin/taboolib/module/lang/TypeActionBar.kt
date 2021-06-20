package taboolib.module.lang

import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.ProxyPlayer
import taboolib.common.util.replaceWithOrder
import taboolib.module.lang.Language.translate

/**
 * TabooLib
 * taboolib.module.lang.TypeActionBar
 *
 * @author sky
 * @since 2021/6/20 10:55 下午
 */
class TypeActionBar : Type {

    lateinit var text: String

    override fun init(source: Map<String, Any>) {
        text = source["text"].toString()
    }

    override fun send(sender: ProxyCommandSender, vararg args: Any) {
        if (sender is ProxyPlayer) {
            sender.sendActionBar(text.replaceWithOrder(*args).translate(sender))
        } else {
            sender.sendMessage(toString())
        }
    }

    override fun toString(): String {
        return "NodeActionBar(text='$text')"
    }
}