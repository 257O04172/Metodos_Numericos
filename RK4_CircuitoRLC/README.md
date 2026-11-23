SCC-1017 Métodos Numéricos — Actividad Tema 6.3: Sistemas de EDOs y RK4 Vectorial (Circuito RLC)
Implementación en Java del método numérico de Runge-Kutta de 4to Orden (RK4) Vectorial para simular la respuesta libre de un circuito eléctrico RLC serie mediante su transformación a un sistema equivalente de ecuaciones diferenciales ordinarias de primer orden.

Datos Institucionales y del Docente
Campo	Información
Institución	Instituto Tecnológico Superior de Xalapa (ITSX)
Carrera	Ingeniería en Sistemas Computacionales (ISC)
Asignatura	SCC-1017 Métodos Numéricos
Tema	6.3 Sistemas de EDOs y RK4 Vectorial
Docente Titular	Víctor Hugo Vásquez Herrera (victor.vasquez@itsx.edu.mx)
Ubicación	Xalapa-Enríquez, Veracruz, México
Trabajo en Equipo — Integrantes
Óscar Lozada Vargas
María de los Angeles Rocha Botello
María Fátima Sánchez Landa
Modelo Matemático Implementado
Para un circuito RLC serie en respuesta libre con 
L=1 H, R=0.4 Ω y C=1 F:q″(t)+0.4q′(t)+q(t)=0,q(0)=1.0 C,q′(0)=0.0 A

Definiendo las variables de estado 
y1(t)=q(t) (carga) y 
y2(t)=q′(t) (corriente), se obtiene el sistema vectorial de primer orden:

{dy1dt=y2\[8pt]dy2dt=−y1−0.4y2conY→(0)=[1.0 0.0]

Estructura del Repositorio
├── RK4CircuitoRLC.java    # Código fuente en Java con el integrador RK4 vectorial
└── README.md              # Documentación del proyecto, integrantes e instrucciones de ejecución
Instrucciones de Clonación, Compilación y Ejecución desde Terminal
1. Requisitos previos
Tener instalado el Java Development Kit (JDK 8 o superior) (javac y java disponibles en el PATH del sistema).
2. Clonar el repositorio
(https://github.com/AngieeBotello07/METODOS-NUMERICOS/tree/main/RK4%20Circuito%20RLC)
3. Compilar el programa
javac RK4CircuitoRLC.java
4. Ejecutar la simulación
java RK4CircuitoRLC
Ejemplo de Salida en Pantalla (
h=0.2,n=25 puntos)
	 t_n	 y1 (Carga)	 y2 (Corr)
-----------------------------------------------
0	 0.00	 1.000000	 0.000000
1	 0.20	 0.980643	 -0.190814
2	 0.40	 0.925566	 -0.356343
3	 0.60	 0.840033	 -0.493280
4	 0.80	 0.729992	 -0.599581
5	 1.00	 0.601829	 -0.674393
...
24	 4.80	 0.047241	 0.417684
25	 5.00	 0.130220	 0.409004
👩‍💻 Autoría
Desarrollado por María Fátima Sánchez Landa,María de los Angeles Rocha Botello y Óscar Lozada Vargas (3° "B" - ISC, ITSX) bajo la cátedra del Ing. Víctor Hugo Vásquez Herrera
