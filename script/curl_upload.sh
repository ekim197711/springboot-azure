cd $(dirname $0)
curl -F "file=@./MikeVacation.jpg" "http://localhost:8080/api/blob/upload"