##HTTP 1.x 与2.0的区别
###1.http2使用二进制分帧：
 2.x在应用层(HTTP2)和传输层（TCP,UDP）中间增加了一个二进制分帧层吗。作用是将请求头和请求数据进行二进制编码分帧再进行传输，单个请求帧必须先进先出，但是不同请求之间的帧可以进行穿插进行并发请求，
单个连接可以多请求，单个请求不会影响整体服务器响应时间。

###2.Header Compression
1.x的头部一直都是纯文本（Plain text）,方便抓包，Https会把头信息加密。
2.x 使用HPACK压缩头部，对于固定报文头部，通过静态索引表方式来维护头部键值对，对于不固定报文头部则会动态维护一张动态表，最后再通过Haffuman编码，进一步压缩头部大小。method:Get对应静态表中的2、user-agent：Mozilla/5.0对应62。

###3.Server Push
 这个功能通常被称作“缓存推送”。主要的思想是：当一个客户端请求资源X，而服务器知道它很可能也需要资源Z的情况下，服务器可以在客户端发送请求前，主动将资源Z推送给客户端。这个功能帮助客户端将Z放进缓存以备将来之需。服务器推送需要客户端显式的
允许服务器提供该功能。但即使如此，客户端依然能自主选择是否需要中断该推送的流。如果不需要的话，客户端可以通过发送一个RST_STREAM帧来中止。


