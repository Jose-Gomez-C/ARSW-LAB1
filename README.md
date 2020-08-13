# ARSW-LAB1
## Part I - Introduction to threads in JAVA
###¿Cual es la diferencia de utilizar el metodo run() o start()?
Cuando utilizamos el metodo start() para el objeto CountThread lo que esta haciendo es crear el hilo y cambiar el estado a Runnable, 
cuando le decimos al objeto de CountThread start() 2 veces, esta cambiando
el estado de Runnable a Runnable , esto hace que genere un error de java.lang.IllegalThreadStateException. 
El metodo run() lo que hace es ejecutar el hilo sin tener que cambiarle el estado  al hilo.
