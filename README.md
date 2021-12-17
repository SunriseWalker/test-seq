
#本示例使用nacos为服务注册中心

# 试验spring中几个扩展点的顺序

```
in HandlerInterceptor.preHandle
in RequestBodyAdvice, supports
in RequestBodyAdvice, beforeBodyRead
in AbstractHttpMessageConverter  readInternal
in RequestBodyAdvice, supports
in RequestBodyAdvice, afterBodyRead
校验
in around, before
in before
in controller
in around, after
in after
in ResponseBodyAdvice, supports
in ResponseBodyAdvice, beforeBodyWrite
in AbstractHttpMessageConverter  writeInternal
in HandlerInterceptor.postHandle
in HandlerInterceptor.afterCompletion
```
```
in HandlerInterceptor.preHandle
in RequestBodyAdvice, supports
in RequestBodyAdvice, beforeBodyRead
in AbstractHttpMessageConverter  readInternal
in RequestBodyAdvice, supports
in RequestBodyAdvice, afterBodyRead
校验错误 
in HandlerInterceptor.afterCompletion
in HandlerInterceptor.preHandle
in ResponseBodyAdvice, supports
in ResponseBodyAdvice, beforeBodyWrite
in AbstractHttpMessageConverter  writeInternal
in HandlerInterceptor.postHandle
in HandlerInterceptor.afterCompletion
```

发校验不通的请求，还不到```around```的```before```，即校验在切面之前  
校验不同的请求示例：
```
curl -XPOST localhost:8080/hello -d "{"""msg""":null}" -H "Content-Type: application/json"
```
校验在```RequestResponseBodyMethodProcessor#resolveArgument(...)```