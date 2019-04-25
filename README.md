![](TP2Ahorcado.png)

# Ahorcado
TP 2 - Laboratorio 5

## Diferencia entre Runnable y Thread
- Thead es una clase y se usa si no se planea heredar
- Runnable es una interfaz y se usa si se planea heredar

En ambos casos, se deber definir un método run que será el incluya las instrucciones que se ejecutarán en el thread.

Para Thread simplemente se usa el metodo start en una instancia del ojeto.

En cambio para Runnable se debe usar una instancia de Thread pasandole al constructor una instancia del objeto que implementa Runable 

## Ciclo de vida de un Thread

1. New: El thread está en nuevo estado si creas una instancia de la clase Thread pero antes de la invocación del método start ().

2. Runnable: El thread está en estado ejecutable (runnable) después de la invocación del método start (), pero el programador de threads (thread scheduler) no lo ha seleccionado como el thread en ejecución.

3. Running: El thread está en estado de ejecución si el programador de threads lo ha seleccionado.

4. Non-Runnable (Blocked): Este es el estado en el que el hilo aún está vivo, pero actualmente no es elegible para ejecutarse. Metodos que ponen un thread en este estado son: sleep(), suspend(), wait().

5. Terminated: Un hilo está en estado terminado o muerto cuando su método run () termina.

## Metodos

- Start(): Invoca el método run del objecto que hereda Thread, o implementa la interfaz Runnable, y pasa el thread al ciclo de vida "Runnable".

- Sleep(long miliseconds):  Deja de ejecutar el thread durante el tiempo indicado.

- Yield():  Provoca una pausa temporal en el thread para dar la oportunidad a otros threads de que ejecuten. Se puede utilizar para realizar una planificación factible. 

- Join([long milisecond]): Espera a que termine el thread indicado, o opcionalmente como máximo millis milisegundos antes de morir (en caso de pasado ese tiempo ignora al thread). Se utiliza para esperar el fin de la ejecución de un thread antes de realizar acciones que dependan de ello.