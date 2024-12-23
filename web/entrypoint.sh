microdnf install findutils
echo $1
if [ $1 == true ]
then
  sh gradlew build -continuous & sh gradlew bootRun
else
  sh gradlew build
  java -jar build/libs/theater-reservation-system-0.0.1-SNAPSHOT.jar
fi
