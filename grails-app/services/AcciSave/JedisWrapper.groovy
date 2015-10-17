package AcciSave

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.core.script.DefaultRedisScript

class JedisWrapper {
    private def defaultRedisScript = new DefaultRedisScript<String>()
    private def scriptKeys
    private Object[] scriptArgs
    private StringRedisTemplate stringRedisTemplate

    public JedisWrapper(String script, Class<String> resultType, List<String> scriptKeys, Object[] scriptArgs) {
        defaultRedisScript.setScriptText(script)
        defaultRedisScript.setResultType(resultType)
        this.scriptKeys = scriptKeys
        this.scriptArgs = scriptArgs
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()
        ctx.register(RedisConfig.class)
        ctx.refresh()
        stringRedisTemplate = ctx.getBean(StringRedisTemplate.class)
    }
	
    public def executeLuaScript() {
        stringRedisTemplate.execute(defaultRedisScript, scriptKeys, scriptArgs)
    }
}
