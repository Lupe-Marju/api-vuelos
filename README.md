# api-vuelos
Lenguaje: JAVA
Tecnologías: SpringWeb, Lombok
Arquitectura de capas: service, controller, model, repository, util, dto.

¿Qué hace?
Permite realizar operaciones CRUD sobre vuelos. 
1. Get: /vuelos _ Listar vuelos: permite ver todos los vuelos. Se pueden colocar filtros como empresa, fecha de salida o llegada, ciudad de destino o llegada. Por defecto, los vuelos se ordenan por fecha de salida, pero se puede indicar para ordenar por empresa o ciudad de llegada.
2. Get: /vuelos/{id} _ Buscar un vuelo por su id: encuentra un vuelo por su id. Si no lo encuentra, devuelve null.
3. Post: /vuelos _ Agregar un vuelo: permite agregar un vuelo nuevo y hace una comprobación para ver si todos los campos han sido ingresados. El id se genera y se agrega automáticamente. La información sobre el vuelo se pasa en el body del request.
4. Put: /vuelos/{id} _ Modificar un vuelo: a través del id, se modifican los datos de un vuelo. La información sobre el vuelo se pasa en el body del request.
5. Delete: /vuelos/{id} _ Eliminar un vuelo: a través del id, se elimina un vuelo.

Puedes revisar el uso de los endpoint aquí:
http://localhost:8080/doc/swagger-ui/index.html

Otras especificaciones
La base de datos está en memoria.
Información sensible de vuelos está protegida por un dto.
Incluye un documento de Postman con los json para probar la api.
