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

1. Github

2. Github Actions

3. Jenkins 自动打包部署

# 步骤

```
name: Test - CI

on:
  # Trigger the workflow on push,
  # but only for the master branch
  push:
    branches:
      - master


jobs:
  build:

    runs-on: ubuntu-latest

    steps:
      - name: Start
        run: echo start ...
      - name: Jenkins execute
        run: curl http://106.12.34.36:8389/job/mall/build?token=TOKEN_AUTOMALL

```
