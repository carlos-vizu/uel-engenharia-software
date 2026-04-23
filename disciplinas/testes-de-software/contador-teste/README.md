# ContadorTeste — Análise de Testes

![Tests](https://img.shields.io/badge/tests-5%20passing-brightgreen)
![Coverage](https://img.shields.io/badge/coverage-96,9%25-green)
![Java](https://img.shields.io/badge/Java-21-blue)


---

## 1. Grafo do Módulo

```mermaid
flowchart TD
    subgraph inicio
        0((0))
    end

    subgraph if
        1((1))
        2((2))
    end

    subgraph while
        3((3))
        4((4))
    end

    subgraph if / if else / else
        direction LR
        5((5))
        6((6))
        7((7))
        8((8))
    end

    subgraph fim
        9((9))
    end

    0 --> 1
    0 --> 2
    1 --> 3
    2 --> 9
    3 --> 4
    5 --> 3
    6 --> 3
    7 --> 3
    8 --> 3
    8 -.-> |estado=0| 3
    3 -.-> |estado=0| 9
    4 --> 5
    4 --> 6
    4 --> 7
    4 --> 8
```

---

## 2. Complexidade Ciclomática

A complexidade ciclomática é calculada pela fórmula:

```
P + 1
```

Onde:
- **P** = Número de predicados (condições)


> **Complexidade Ciclomática = 6**


---

## 3. Erro Encontrado

### 'index' não era auto incrementado
No código original a variável 'index' era inicializada, porém ao entrar no primeiro if, a linha de código originalmente estava: 

```java
index = index = 1;
```

O correto é: 
```java
index = index + 1;
```


---
> ERRO ADICIONAL
### Comparação de Strings com `==`

No código original, as comparações de `String` eram feitas com `==`:

```java
if (s[index] == "B") { ... }
```

Em Java, `==` compara a **referência do objeto** na memória, não o conteúdo. Isso pode retornar `false` mesmo quando os valores são iguais, dependendo de como a `String` foi criada.

**Correção aplicada:**

```java
if (s[index].equals("B")) { ... }
```

### Ausência da String `"\n"`

O loop `while(estado != 0)` só encerra quando encontra o caractere `"\n"` no array. Sem ele, o `index` continua incrementando até estourar o array:

```
Exception: ArrayIndexOutOfBoundsException
```

**Correção aplicada:** o array sempre é montado com `"\n"` na última posição:

```java
String[] entrada = new String[linha.length() + 1];
for (int i = 0; i < linha.length(); i++) {
    entrada[i] = String.valueOf(linha.charAt(i));
}
entrada[linha.length()] = "\n"; // string obrigatório
```

---

## 4. Resultados e Análise dos Testes


### Cenários de Teste

A complexidade ciclomática é **6**, porém a análise do grafo revelou que:

- O caminho `0 > 1 > 3 > 9` é **inalcançável**, pois `while(estado != 0)` com `estado = 1` sempre executa o corpo ao menos uma vez (do-while).
- O caminho `0 > 1 > 3 > 4 > 8 > 3 > 9` já está coberto pelo cenário mínimo `{"A", "\n"}`.

Portanto, os **4 cenários reais e independentes** são:

| # | Caminho | Entrada | Resultado Esperado |
|---|---------|---------|-------------------|
| 1 | `0 > 2 > 9` | `{"X", "\n"}` | `-1` |
| 2 | `0 > 1 > 3 > 4 > 8 > 3 > 9` | `{"A", "\n"}` | `0` |
| 3 | `0 > 1 > 3 > 4 > 5 > 3 > 4 > 8 > 3 > 9` | `{"A", "B", "\n"}` | `0` |
| 4 | `0 > 1 > 3 > 4 > 6 > 3 > 4 > 8 > 3 > 9` | `{"A", "B", "C", "\n"}` | `1` |
| 5 | `0 > 1 > 3 > 4 > 7 > 3 > 4 > 8 > 3 > 9` | `{"A", "D", "\n"}` | `0` |

---
