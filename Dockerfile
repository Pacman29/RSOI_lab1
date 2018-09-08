FROM openjdk:10
RUN apt-get update

EXPOSE 80
RUN mkdir ./app
COPY ./target/rsoi.jar ./app
COPY ./run.sh ./app
WORKDIR ./app
RUN chmod +x ./run.sh
CMD "./run.sh"