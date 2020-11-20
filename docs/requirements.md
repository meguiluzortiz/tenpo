# Requerimientos

1. Debes desarrollar una API REST en Spring Boot con las siguientes funcionalidades
   1. Sign up usuarios.
   2. Login usuarios vía JWT.
   3. Sumar dos números. Este endpoint debe retornar el resultado de la suma y 4. puede ser consumido solo por usuarios logueados.
   4. Historial de todas las operaciones por usuario. Responder en Json, con data paginada y el límite se encuentre en properties.
   5. Logout usuarios.
   6. El historial y la información de los usuarios se debe almacenar en una database PostgreSQL.
   7. Incluir errores http. Mensajes y descripciones para la serie 400.
2. Esta API debe ser desplegada en un docker container. Este docker puede estar en un dockerhub público. La base de datos también debe correr en un contenedor docker.
3. Debes agregar un Postman Collection o Swagger para que probemos tu API.
4. Tu código debe estar disponible en un repositorio público, junto con las instrucciones de cómo desplegar el servicio y cómo utilizarlo.
