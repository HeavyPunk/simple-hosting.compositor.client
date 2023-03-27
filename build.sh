DEST_DIR=./build
sbt package

rm -rf $DEST_DIR
mkdir $DEST_DIR
cp ./target/simplehosting-compositor-client-0.1.0-SNAPSHOT.jar $DEST_DIR/simple-hosting-compositor-client.jar