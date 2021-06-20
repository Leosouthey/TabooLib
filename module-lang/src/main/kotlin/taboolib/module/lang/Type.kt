package taboolib.module.lang

import taboolib.common.platform.ProxyCommandSender

/**
 * node:
 * - type: text
 *   text: hello world!
 * - type: title
 *   title: hello world!
 *   subtitle: sub
 *   fadein: 1
 *   stay: 1
 *   fadeout: 1
 * - type: sound
 *   sound: block_stone_break
 *   volume: 1
 *   pitch: 1
 *
 *
 *
 * TabooLib
 * taboolib.module.lang.Type
 *
 * @author sky
 * @since 2021/6/20 10:53 下午
 */
interface Type {

    fun init(source: Map<String, Any>)

    fun send(sender: ProxyCommandSender, vararg args: Any)

}