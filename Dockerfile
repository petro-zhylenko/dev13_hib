FROM postgres
ENV POSTGRES_USER dev13
ENV POSTGRES_PASSWORD dev13pass
EXPOSE 5432:5432
ENV POSTGRES_DB myBb

#docker build -t pg/dev13:v1 .
#docker run --name pg_dev13 -d -p 5432:5432 pg/dev13:v1