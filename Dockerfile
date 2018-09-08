FROM openjdk:10
RUN apt-get update

EXPOSE 80
RUN mkdir ./app
ADD ./target/rsoi.jar ./app
ADD ./run.sh ./app
WORKDIR ./app
RUN chmod +x ./run.sh
CMD "./run.sh"