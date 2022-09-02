# 若依 MybatisPlus 纯净版

本项目的文档和若依官方文档一样，因为只做了持久层增强，没有改变依赖，对于首次使用若依的小伙伴，可能要下一点功夫研究怎么使用若依了

## 客户端

### 服务端：ruoyi-vue-service

为了保证大家使用起来顺手，对于若依的 RuoYi-Vue 版本，没有任何改动，只是集成了 MybatisPlus 作为持久层框架，去除了 Mybatis 依赖，替换为了 MybatisPlus 依赖，原先的 PageHelp 分页插件也没有改动， 增加了 MybatisPlus 的分页功能、全局逻辑删除字段、公共字段自动补全等功能

### PC 端：ruoyi-vue-web

开发

```shell
# 安装依赖
npm install

# 建议不要直接使用 cnpm 安装依赖，会有各种诡异的 bug。可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npmmirror.com

# 启动服务
npm run dev
```

发布

```shell
# 构建测试环境
npm run build:stage

# 构建生产环境
npm run build:prod
```

### 用户端：ruoyi-vue-app-user

用户端采用的是 uview2.x 的版本作为项目基础框架，前端时间 uview2.x 刚发布确实还不稳定，但是经过 uview 团队的不断维护更新，已经明显能感觉到新版本的 bug 基本上全都优化完成了，所以这里的用户端直接采用 uniapp + uview2.x 作为前端基础框架

由于 uniapp 的特性，开发一套能打包成不同模式的前端项目，下面我列举了平时开发中常用的版本，后面项目中我会陆续把对应版本的使用方式集成到项目文档中，大家可以关注文档的更新动态，https://gitee.com/tellsea/ruoyi-vue-plus/wikis

- H5
- 微信公众号
- 微信小程序
- App

## 生产部署

### Nginx 配置

主要是 Nginx 部署，这里给一个完整案例

```shell
#user  nobody;
worker_processes  1;

events {
    worker_connections  1024;
}

http {
    include       mime.types;
    default_type  application/octet-stream;

    sendfile        on;
	client_max_body_size 100M;

    keepalive_timeout  65;

    server_names_hash_bucket_size 64;

	server {
        listen       443 ssl;
        server_name  ruoyi-vue.tellsea.cn;
        #ssl on;
        ssl_certificate      绝对路径.pem;  #这里是ssl key文件存放的绝对路径，根据自己的文件名称和路径来写
        ssl_certificate_key  绝对路径;  #这里是ssl key文件存放的绝对路径，根据自己的文件名称和路径来写
        ssl_session_cache    shared:SSL:1m;
        ssl_session_timeout  5m;
        ssl_ciphers  HIGH:!aNULL:!MD5;
        ssl_prefer_server_ciphers  on;


		location /ruoyi-vue-app-user {
			root /tellsea/project/ruoyi-vue;
			index  index.html index.htm;
		}

		location /ruoyi-vue-web {
			root /tellsea/project/ruoyi-vue;
			index  index.html index.htm;
			try_files $uri $uri/ /ruoyi-vue-web;
		}

		location /ruoyi-vue-service {
			proxy_redirect http:// https://;
			proxy_set_header Host $http_host;
			proxy_set_header X-Real-IP $remote_addr;
			proxy_set_header REMOTE-HOST $remote_addr;
			proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
			proxy_pass http://127.0.0.1:8080/ruoyi-vue-service;
		}
    }
}
```
