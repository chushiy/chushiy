接口数据加密
对接口出参加密，入参解密

# 问题 在接口调用链中，request的请求流只能调用一次，处理之后，如果之后还需要用到请求流获取数据，就会发现数据为空。

比如使用了filter或者aop在接口处理之前，获取了request中的数据，对参数进行了校验，那么之后就不能在获取request请求流了
1.request流只能读取一次的问题