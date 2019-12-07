# Docker

## redis

``` lang: shell
docker run -itd --name redis -p 6379:6379 redis
```

## mongo

``` lang: shell
docker run -itd --name mongo -p 27017:27017 mongo
```

## cadvisor docker 性能监控

``` lang: shell
docker run                                      \
> --volume=/:/rootfs:ro                         \
> --volume=/var/run:/var/run:rw                 \
> --volume=/sys:/sys:ro                         \
> --volume=/var/lib/docker/:/var/lib/docker:ro  \
> --publish=8080:8080                           \
> --detach=true                                 \
> --name=cadvisor                               \
> google/cadvisor:latest
```

``` lang: shell
docker run -d  --name scout-agent                              \
-v /proc:/host/proc:ro                                               \
-v /etc/mtab:/host/etc/mtab:ro                                   \
-v /var/run/docker.sock:/host/var/run/docker.sock:ro    \
-v `pwd`/scoutd.yml:/etc/scout/scoutd.yml                     \
-v /sys/fs/cgroup/:/host/sys/fs/cgroup/                           \
--net=host --privileged                                                   \
soutapp/docker-scout
```

## docker 以交互方式执行

``` lang: shell
docker exec -it 【containerID/containerName】 /bin/sh -c "[ -e /bin/bash ] && /bin/bash || /bin/sh"
```
