# 🃏 UNO 5.0 - Juego en Java

Proyecto de un juego UNO desarrollado en Java con interfaz gráfica Swing, inteligencia artificial básica y lógica completa de reglas.

---

## 📌 Descripción

UNO 5.0 es una implementación del clásico juego de cartas UNO, donde un jugador humano compite contra bots controlados por IA.

Incluye manejo de cartas, reglas oficiales, turnos dinámicos y una interfaz gráfica interactiva.

---

## 🎮 Características

- Modo jugador vs IA
- Bots con comportamiento automático
- Mazo completo de cartas UNO
- Sistema de turnos y reversa
- Interfaz gráfica con Swing
- Cartas especiales:
  - Salto
  - Reversa
  - Roba 2
  - Roba 4
  - Comodín

---

## 🚀 Cómo ejecutar

1. Compilar el proyecto:

javac UNO5_0/*.java

2. Ejecutar:

java UNO5_0.Main

---

## 🧠 Reglas del juego

- Se puede jugar una carta si coincide en color o número
- Las cartas negras (comodín y +4) son siempre válidas
- Efectos especiales:
  - Salto: el siguiente jugador pierde turno
  - Reversa: cambia el orden del juego
  - Roba 2: el siguiente jugador roba 2 cartas
  - Roba 4: roba 4 cartas y cambia el color
  - Comodín: permite elegir color

- Gana el jugador que se queda sin cartas

---

## 🤖 Inteligencia artificial

Los bots pueden:

- Jugar automáticamente cartas válidas
- Robar cartas si no tienen jugadas posibles
- Elegir colores aleatorios en comodines
- Ejecutar su turno sin intervención del usuario

---

## 🖥️ Interfaz gráfica

- Mesa central con carta actual
- Mano del jugador con cartas clicables
- Animaciones hover en cartas
- Registro de eventos en tiempo real
- Indicador de color activo
- Visualización de bots

---

## 📦 Tecnologías usadas

- Java SE
- Swing
- AWT
- Programación Orientada a Objetos
- Estructuras de datos (List, Stack)

---

## 👨‍💻 Autor

Cruz Mejia Oscar Adolfo y Ordaz Reyes Evelyn Julieta

---

## 🚀 Mejoras futuras

- Multijugador online
- IA más inteligente
- Sonidos y efectos
- Animaciones avanzadas
- Sistema de puntuación
