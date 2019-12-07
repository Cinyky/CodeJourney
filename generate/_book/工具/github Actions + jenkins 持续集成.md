# 简介
项目托管在Github上，jenkins已经实现自动打包部署任务。每一次代码更新都需要登录jenkins进行点击操作，过于繁琐。

# 专业词汇
> - CI      Continuous Integration   持续集成，Github Actions 提供了持续集成方案
> - CD    Continuous Deployment 持续发布
> - WorkFlow 工作流，类似于流水线


# 目标
Github Actions + Jenkins 实现CI & CD
Github Actions监听master分支push event，curl 发送到之前已经部署好的Jenkins Job API，进行自动打包，停服更新。

# 物料
>像做菜一样，下面使我们拥有的物料 --- 沃兹基硕德

1. `Github project`

2. `Github Actions`

3. `Jenkins Job`


# 步骤
1. 创建Github Actions
`新建项目或者使用已有项目进行创建Actions`
![Github Actions - 1.png](https://upload-images.jianshu.io/upload_images/6872108-a27bad5b591b7d9a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
选择自定义的方式创建
![Github Actions - 2.png](https://upload-images.jianshu.io/upload_images/6872108-ecc92a06a4592cdb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

创建完成后生成的模板文件
![Github Actions - 3.png](https://upload-images.jianshu.io/upload_images/6872108-02f21fe906029f21.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
代码文件
```
# CI名称
name: CI
# 监听事件，可选push，pull request
on: [push]

# 任务创建
jobs:
  build:

    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v1
    - name: Run a one-line script
      run: echo Hello, world!
    - name: Run a multi-line script
      run: |
        echo Add other actions to build,
        echo test, and deploy your project.

```

2. 写我们自己需要的CI
```
name: Test - CI

  # Trigger the workflow on push,   
  # but only for the master branch
on:
  push:
    branches:
      - master


jobs:
  build:

    runs-on: ubuntu-latest

    steps:
      - name: Jenkins execute
        run: curl http://[ip:port]/job/mall/build?token=[TOKEN]

```
- 监听分支master的push事件
- 运行环境`ubuntu-latest`
- 添加任务 curl访问jenkins开放端口
![jenkins API.png](https://upload-images.jianshu.io/upload_images/6872108-9ae47e4bbfd48fa0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
- 遇到权限问题时，按下图进行配置jenkins
![jenkins 配置.png](https://upload-images.jianshu.io/upload_images/6872108-227e0ec986317bec.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



