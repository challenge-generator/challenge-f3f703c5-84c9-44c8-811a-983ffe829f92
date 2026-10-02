# Fundamentos de la Programación Orientada a Objetos

En el ámbito de desarrollo de software para sistemas bancarios, la aplicación de los principios de la Programación Orientada a Objetos (OOP) es crucial para construir soluciones robustas y escalables. En este reto, explorarás los pilares de OOP y su aplicación en un dominio real de banca, donde deberás modelar y diseñar clases que representen entidades como 'Cuenta Bancaria', 'Cliente', y 'Transacción'. El objetivo es entender y aplicar los conceptos de encapsulamiento, herencia, polimorfismo y abstracción en el contexto de un sistema de gestión de cuentas bancarias.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Desarrollo de Software con OOP |
| **Nivel** | senior-l2 |
| **Tipo** | theoretical |
| **Tiempo estimado** | 2 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Entender los Pilares de OOP

**Objetivo:** Identificar y describir los cuatro pilares de la Programación Orientada a Objetos y su importancia en el desarrollo de software.

**Tiempo estimado:** 30 minutos

**Instrucciones:**

- Lee y reflexiona sobre cada uno de los pilares de OOP: encapsulamiento, herencia, polimorfismo y abstracción.
- Identifica ejemplos de cada pilar en el contexto de un sistema bancario.
- Describe cómo cada pilar contribuye a la robustez y mantenibilidad del software.

**Entregable:** Un documento que describe cada pilar de OOP, ejemplos en el contexto bancario y su contribución a la robustez del software.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en cómo las clases 'Cuenta Bancaria' y 'Cliente' pueden relacionarse a través de la herencia.
- Considera cómo el polimorfismo puede ser aplicado en la gestión de diferentes tipos de transacciones.

</details>

### Fase 2: Aplicar OOP en un Sistema Bancario

**Objetivo:** Diseñar clases que representen entidades bancarias aplicando los principios de OOP.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Diseña las clases 'Cuenta Bancaria', 'Cliente' y 'Transacción' aplicando los principios de OOP.
- Define los atributos y métodos que cada clase debe tener.
- Identifica las relaciones entre las clases y cómo aplican los pilares de OOP.

**Entregable:** Un diagrama de clases que representa 'Cuenta Bancaria', 'Cliente' y 'Transacción', incluyendo atributos, métodos y relaciones entre clases.

<details>
<summary>Pistas de conocimiento</summary>

- Reflexiona sobre cómo la abstracción puede ser usada para definir métodos comunes en 'Cuenta Bancaria' y 'Transacción'.
- Considera el uso de genéricos para manejar diferentes tipos de datos en las transacciones.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los pilares de la Programación Orientada a Objetos y cómo se aplican en un sistema bancario?
- **paraQueSirve**: ¿Cómo contribuyen los pilares de OOP a la robustez y mantenibilidad del software en un contexto bancario?
- **comoSeUsa**: ¿Cómo diseñarías las clases 'Cuenta Bancaria', 'Cliente' y 'Transacción' aplicando los principios de OOP?
- **erroresComunes**: ¿Cuáles son los errores comunes al aplicar OOP en el desarrollo de software y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones de diseño implica la aplicación de OOP en un sistema bancario y cómo afectan a la estructura del software?

## Criterios de Evaluacion

- Identificación y descripción correcta de los pilares de OOP.
- Aplicación adecuada de los principios de OOP en el diseño de clases para un sistema bancario.
- Reflexión sobre los errores comunes y cómo evitarlos en la aplicación de OOP.
- Justificación de decisiones de diseño basadas en criterios claros y objetivos.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
