#!/usr/bin/env sh

. ./helm-env.sh

helm install redis-lab --set "local.volumes.path=$CHARTDIR/volumes" --set "security.uid=$UID"  --set "security.gid=$GID" .
