
FROM dkron/dkron
WORKDIR /root/hello-world
COPY hello.java /root/hello-world

RUN apk add openjdk8 
RUN apk add curl

ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $JAVA_HOME/bin:$PATH

RUN javac hello.java