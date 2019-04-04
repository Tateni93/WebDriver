#!/bin/sh
 
SM_OUTPUT=$(sm -s | egrep 'PASS|BOOT' | awk '{ print $12 }')
 
if [ "x$SM_OUTPUT" = "x" ]; then
echo "NO PORTS WITH STATUS PASS OR BOOT. EXITING SCRIPT"
exit 1
fi
 
for PORT in $SM_OUTPUT; do
   MAPPED_PORTS="$MAPPED_PORTS$PORT->$PORT,"
done
 
MAPPED_PORTS=${MAPPED_PORTS%?}
 
echo MAPPED_PORTS: $MAPPED_PORTS

# Linux
docker run --network host --rm -d --name chrome -p 4444:4444 -p 5900:5900 -e PORT_MAPPINGS=$MAPPED_PORTS -e TARGET_IP='host.docker.internal' chrome-3.14.0
