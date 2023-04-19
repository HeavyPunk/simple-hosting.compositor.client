DEST_DIR=./build

rm -rf $DEST_DIR target

sbt package

mkdir $DEST_DIR
cp ./target/*.jar $DEST_DIR/