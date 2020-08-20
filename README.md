# ARSW-LAB1

## Requerimientos 
Se necesita que tenga instalado en su computadora:
```sh
$ Java 1.8
$ Maven 3.6.3
```
con su respectiva configuracion
## Instalación
> **Clonar el repositorio:** 
```sh
$ https://github.com/jose-gome/ARSW-LAB1
```
> **Compilar el proyecto:**
```sh
$ mvn package
```
> **Ejecutar el programa BlackListSearh:** 
```sh
$ java -cp target\PiDigits-1.0-SNAPSHOT.jar edu.eci.arsw.blacklistvalidator.Main
```
> **Ejecutar el programa SnakeRace:** 
```sh
$ java -cp target\Snake-race-thread-1.0-SNAPSHOT.jar snakepackage.SnakeApp
```
## Part I - Introduction to threads in JAVA
### ¿Cual es la diferencia de utilizar el metodo run() o start()?

> Ejecutando el hilo con el metodo run():
- ![Ejecucion run()](https://i.ibb.co/rstL92w/RUN.png)
> Ejecutando el hilo con el metodo start():
- ![Ejecucion run()](https://i.ibb.co/SJy4z7t/START.png)
> **Cuando utilizamos el metodo start() para el objeto CountThread lo que esta haciendo es crear el hilo y cambiar el estado a Runnable, cuando le decimos al objeto de CountThread start() 2 veces, esta cambiando el estado de Runnable a Runnable , esto hace que genere un error de java.lang.IllegalThreadStateException.** 
> **El metodo run() lo que hace es ejecutar el hilo sin tener que cambiarle el estado mas de una vez, por lo que hace el llamado a un metodo de una clase esto hace que no haga otra instruccion hasta que acabe el metodo por eso se puede ver en orden la ejecucion y cuando lo ejecutamos con el metodo start() se ve desordenado.**

## Part III - Discussion
### The strategy of parallelism previously implemented is inefficient in certain cases, since the search is still carried out even when the N threads (as a whole) have already found the minimum number of occurrences required to report to the server as malicious. How could the implementation be modified to minimize the number of queries in these cases? What new element would this bring to the problem?
> **La estrategia utilizada fue muy ineficiente debido a que muchas veces ya se encontraba el número de servidores maliciosos y aun así, el programa se seguía ejecutando. Una solución para acabar con esta ineficiencia es llevar una variable atómica que lleve el número de servidores maliciosos y de esta manera los hilos podrán revisarla y no tendrán que realizar ejecuciones adicionales**

## Part IV - Performance Evaluation
### A Single Thread
![UnSoloHilo](https://i.ibb.co/kMkxqjG/Un-Solo-Hilo.png)
### As many threads as processing cores (have the program determine this using the Runtime API). 
![Hilos](https://i.ibb.co/p15dYrG/Threads-Api.png)
### As many threads as twice the number of processing cores. 
![Hilos](https://i.ibb.co/GRcDRDF/mismo-Procesador.png)
### 10 Threads
![10Hilos](https://i.ibb.co/wQcsMs0/10Hilos.png)
### 50 Treads
![50Hilos](https://i.ibb.co/wBP6vnS/50Hilos.png)
### 100 Threads
![100Hilos](https://i.ibb.co/VmJpXJX/100Hilos.png)
### According to Amdahls law, where S(n) is the theoretical improvement of performance, P the parallel fraction of the algorithm, and n the number of threads, the greater n, the better this improvement should be. Why is the best performance not achieved with the 500 threads? How is this performance compared when using 200 ?.
> La ley de Amdahl nos habla que  El incremento de velocidad de un programa utilizando múltiples procesadores en computación distribuida está limitada por la fracción secuencial del programa. En la blackList logramos incrementar la velocidad del programa mediante diferentes hilos. Logramos observar que a medida que incrementábamos la cantidad de hilos teníamos cada vez un incremento mas pequeño en la velocidad

## SNAKE_RACE
Las respuestas las puede ver en el archivo ![ANSWERS](https://github.com/jose-gome/ARSW-LAB1//blob/master/ANSWERS.txt)


## Autores
- **Brayan Felipe Rojas Bernal**
- **Jose Luis Gomez Camacho**

## Licencia
Este proyecto posee la licencia MIT. Para mas detalles [Licencia]((https://github.com/jose-gome/ARSW-LAB1//blob/master/LICENSE.txt).

