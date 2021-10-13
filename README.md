# Domicilio-Restaurante-3Spring
## Colaboradores

KEVITH FELIPE BASTIDAS CHILITO

YEISON ORDOÑEZ

WHALEN STIVEN CAICEDO

JUAN DAVID MUÑOZ PASQUEL
#

## Contexto de la app

Mac Restaurant surge como una nueva opción para losrestaurantes de la ciudad de
Popayán, esta es la aplicación que se va a construir como solución y aporte a
la opción de Delivery de los distintosrestaurantes, partiendo de una necesidad
común y unos requerimientosespecíficos; en este documento se plantea la
presentación del sistema, en términos generales.

Es una aplicacion de escritorio, desarrollada en el lenguaje de programación Java
en el entorno de desarrollo Apache Neatbeans IDE 12 utilizando como backend
microservicios en Spring boot.

1. [Documento De Presentacion](https://drive.google.com/file/d/11ztUjuVNEuCKLFDDbbKhuJJGnAZrLAZK/view?usp=sharing)
2. [Descripcion De Requerimientos](https://drive.google.com/file/d/1G5MbKziyzrnuAYTUFZdLjj8x8PVeNlrU/view?usp=sharing)
3. [Definicion De La Arquitectura](https://drive.google.com/file/d/1zyhaZ5ZKF5dCqTpysxy1SGf_9DRNLR7H/view?usp=sharing)
#

## Video del software funcional

[![Alt text](https://img.youtube.com/vi/lpYUCsV-dDo/0.jpg)](https://www.youtube.com/watch?v=lpYUCsV-dDo)

#

## Manual De Desarrollo

1. Estilo arquitectónico: Los requerimientos mostrados de importancia arquitectural indican que cada restaurante tiene un tipo de plato 
(hasta el momento pueden ser platos ejecutivos o platos a la carta) que con el pasar del tiempo, puede escalar (ya no serían solamente 
platos ejecutivos y platos a la carta, sino que puede incluirse comida rápida, por ejemplo), esto permitirá que muchos restaurantes más 
se hagan aliados a la plataforma. Uno de los puntos fuertes de los microservicios es, precisamente, el favorecer la escalabilidad, seguido 
de brindar facilidad en el mantenimiento de cada subsistema, además de permitir la reutilización de código a la hora de un nuevo reléase, 
favoreciendo así uno de los atributos priorizados (Mantenibilidad). Por otro lado, una de las grandes ventajas de los microservicios es que 
permite especializar muy bien ciertas tareas (algo que puede ayudarnos a la hora de, por ejemplo, crear un nuevo tipo de plato – es posible 
tener microservicios que se especialicen en la gestión de cada tipo de plato) favoreciendo otro de los atributos de calidad priorizados 
anteriormente (Adecuación funcional). 
Por su parte, La arquitectura hexagonal es utilizada con el fin de mejorar la arquitectura de tres capas colocando en el centro de la aplicación 
el dominio o la lógica del negocio y haciendo que las demás capas sean exteriores y dependan de la lógica de negocio. De tal que la aplicación 
será fácil de modificar y nos permitirán hacer cambios en la aplicación de manera más fácil, permitiéndonos tener más cohesión, mejor acoplamiento.

2. Lenguaje de programación: Se utilizará el lenguaje de programación Java, debido a que el grupo de desarrollo del proyecto cuenta con 
experiencia y un grado de experticia en el mismo. Además de esto, Java tiene varias especificaciones de API, como JDBC (brindando una alternativa 
para la conexión a base de datos), e-mail (necesaria para la interfaz y la interacción del repartidor). Por último, pero no menos importante, 
Java se ejecuta en una máquina virtual, brindando la opción de trabajarlo en múltiples plataformas.

3. Framework: Para este desarrollo se hará uso de Spring Boot, framework JEE partidario de SpringFramework. Este framework facilita tanto la tarea de 
desarrollo como la tarea de despliegue en un servidor. Spring Boot se enfoca en facilitar las tareas que no son de desarrollo, para que cada 
desarrollador se encargue y se enfoque únicamente en la tarea de desarrollar, ganando tiempo y esfuerzo.

4. Tipo de aplicación: Lo adecuado para una aplicación de esta categoría, serían aplicaciones web, sin embargo, el equipo de desarrollo cuenta con 
falta de experiencia sobre las mismas y sobre aplicaciones Android. Por lo mismo, se toma la inclinación hacia aplicación de escritorio, con una 
posibilidad de complementarse muy bien, en un futuro y en versiones posteriores, con páginas y aplicaciones web, además de aplicaciones para smartphone 
también.

#

##Lecciones Aprendidas
Lecciones aprendidas:
1. En primer lugar, es importante mencionar que se tuvo un fuerte aprendizaje sobre el trabajo y la organización de un equipo. Tomando como base que cuando 
el equipo se ausenta, uno de los integrantes tiene que hacerse cargo de toda la responsabilidad,  cargándose con demasiado trabajo.

2. Se tuvo un aprendizaje de la distribución de la carga o del trabajo en todo el equipo, no solamente poniendo todo el trabajo en una sola persona

3. El equipo tuvo un aprendizaje del manejo y la organización de las arquitecturas de Software, además del uso de múltiples patrones de diseño para mejorar 
el Software que se esté realizando

4. Una lección aprendida, importante fue el aprovechamiento del material y las bases que se dan por parte de los docentes,  siendo que estos otorgan un gran 
conocimiento. Es importante mencionar que también se tuvo un gran aprendizaje buscando material externo para claridad de algunos temas.

5. Una de las lecciones más influyentes es la organización del tiempo, con el fin de no sobrecargarse de trabajo uno o dos días antes de las entregas 
correspondientes.

#

