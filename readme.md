# eLearning Analytics Kata

En un sistema de analítica de datos educativos utilizamos las interacciones de los alumnos con
los contenidos digitales para obtener información de valor de cara al profesor.

Uno de los datos que solemos necesitar son los tiempos que transcurren entre interacciones, con el 
fin de obtener patrones de comportamiento. A estos tiempos le llamamos _Tiempos de Interación_ (TI) y se obtienen
restando los tiemstamps de cada interacción.

En este ejercicio disponemos de la clase _Attempt_, la cual contiene los datos relativos a un intento
de un ejercicio, esta clase contiene todos los timestamps obtenidos de las interacciones 
generadas por el alumno.

Nuestro cliente nos ha ido pedido las siguientes funcionalidades:


#### Fase 1
Al principio del proyecto nos solicita que implementemos un servicio que devuelva
un array con todos los TI para un intento, es decir, si tenemos tres interacciones:

```$xslt
["1559166393444", "1559166393644" ,"1559166393664"]
```

la respuesta de este servicio será: 

```$xslt
["200", "20"]
```

#### Fase 2
Pasado un tiempo, el cliente descubre que los TI muy pequeños no 
representan información de valor, por este motivo solicita que se eliminen todos los timestamps 
del array que tengan una diferencia con el anterior de menos de 20 milisegundos, es decir, que produzcan
un TI menor de 20 milisegundos. Le gustaría seguir teniendo el modo antiguo disponible, 
por lo que debemos parametrizar el servicio para indicarle que tipo de procesamiento queremos aplicar.

```$xslt
["1559166393444", "1559166393644" ,"1559166393664", "1559166393844"]
```

el servicio tendría que eliminar el 3º elemento, y la respuesta sería: 

```$xslt
["200", "200"]
```

#### Fase 3

Tras poner en producción el sistema, los datos revelan que existen casos donde se pruducen tiempos
excesivamente grandes, los cuales son producidos por un mal uso de la plataforma, como dejar la sesión 
conectada de un día para otro. Estos tiempos ensucian los datos y deben ser eliminados, pero para hacerlo
solicitan que sean eliminados aquellos que se alejen en un 90% de la mediana de los tiempos. Este modo debe
realizar también la eliminación de los TI que se produce en la fase 2. De nuevo, quieren
tener disponible la posibilidad de llamar a los dos modos anteriores de cálculo de TI.

```$xslt
["200", "1200", "155", "300", "540"]
```

La respuesta del servicio debería ser:

```$xslt
["200", "155", "300", "540"]
```
