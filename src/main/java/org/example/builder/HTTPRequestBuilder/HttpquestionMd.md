# HTTP Request Builder Library

## Problem Statement

Design and implement an **HTTP Request Builder Library** that can be used by developers to construct HTTP requests in a flexible, readable, and immutable way.

The goal is to:
- Avoid constructors with too many parameters
- Make request creation **clean and extensible**
- Support method chaining and fluent API

### Example Usage

```java
HttpRequest request = HttpRequest.builder()
    .method(HttpMethod.POST)
    .url("https://api.payment.com/v1/pay")
    .addHeader("Authorization", "Bearer token")
    .addHeader("Content-Type", "application/json")
    .addQueryParam("merchantId", "M123")
    .body("{ \"amount\": 100 }")
    .timeout(5000)
    .build();
```

## Requirements

### Functional Requirements

Your builder should support:

1. **Basic Request Information**
   - HTTP Method:
     - `GET`
     - `POST`
     - `PUT`
     - `DELETE`
     - `PATCH`
   - URL (required)

2. **Headers**
   - Add single header
   - Add multiple headers
   - Replace existing header value if same key already exists
   
   **Example:**
   ```java
   .addHeader("Authorization", "Bearer xyz")
   ```

3. **Query Parameters**
   
   Support query parameters like: `/products?page=1&limit=10`
   
   **Example:**
   ```java
   .addQueryParam("page", "1")
   .addQueryParam("limit", "10")
   ```

4. **Request Body**
   
   Support:
   - JSON body
   - Plain text body
   
   *Optional discussion:*
   - Multipart body
   - Form-data support

5. **Timeout Configuration**
   
   **Example:**
   ```java
   .timeout(3000)
   ```

6. **Immutable Final Request Object**
   
   After calling `.build()`, the generated request object should become **immutable**.


## Expectations From Candidate

You are expected to discuss:

- **Class design**
- **Builder Design Pattern**
- **Method chaining / Fluent API**
- **Immutability**
- **Validation**
- **Extensibility**
- **Clean API design**
- **Thread safety considerations**
- **Error handling**

## Follow-up Questions ⭐ (Very Important)

These are usually where interviewers judge strong candidates.

### Follow-up 1 — Validation

**How will you validate:**
- URL is mandatory
- HTTP method is mandatory
- GET request should not have body
- Timeout cannot be negative

**What happens if validation fails?**

### Follow-up 2 — Immutable Object

**How will you ensure the final request object is immutable?**

Discussion points:
- `final` fields
- Defensive copying
- Unmodifiable collections

### Follow-up 3 — Extensibility

**Suppose tomorrow we want:**
- Retry policy
- Authentication strategy
- Compression
- Rate limiting
- Proxy support

**How will your design handle future extensibility?**

### Follow-up 4 — Thread Safety

**Questions:**
- Can multiple threads use the same builder object?
- Should builder be thread-safe?
- Why or why not?

### Follow-up 5 — Director (Advanced)

**Would you introduce a Director class?**

**Example:**
```java
RequestDirector.createDefaultPostRequest()
```

**When is Director useful vs unnecessary?**

### Follow-up 6 — Different Request Types

**How will you support:**
- Multipart request
- Streaming request
- File upload request

**Questions:**
- Would inheritance help?
- Or composition?

### Follow-up 7 — Real Production Discussion

**How do real libraries like:**
- **OkHttp**
- **Retrofit**
- **Apache HttpClient**

use Builder Pattern internally?

**What problems are they solving?**

## Constraints

- ✅ Clean OOP design expected
- ✅ Prefer extensible design over hardcoding
- ✅ Avoid telescoping constructors
- ✅ Follow SOLID principles where applicable
- ✅ Focus more on design than networking implementation

## Bonus Requirements (For Strong Candidates)

If time permits, discuss:

- **Interceptors**
- **Retry mechanism**
- **Request logging**
- **Metrics/tracing**
- **Connection pooling**
- **Async request execution**
- **Request cloning**

## What Interviewer Is Actually Evaluating

The interviewer is mainly checking:

| Area | What They Observe |
|------|-------------------|
| **Builder Pattern Knowledge** | Do you really understand Builder beyond textbook? |
| **API Design** | Is your API intuitive and developer-friendly? |
| **Immutability** | Can you design safe immutable objects? |
| **Extensibility** | Can your design evolve? |
| **Object Modeling** | Proper separation of concerns |
| **Production Thinking** | Can you think beyond toy examples? |
| **Communication** | Can you explain tradeoffs clearly? |

## Interviewer Hint 💡

### ❌ Mediocre Candidate
Only creates:
```java
HttpRequestBuilder
```

### ✅ Strong Candidate
Discusses:
- Validation strategy
- Immutable objects
- Extensibility
- Fluent APIs
- Real-world HTTP clients
- Tradeoffs between inheritance vs composition
- Production-grade concerns

**That is where the interview actually becomes interesting!**
```java
{
"Content-Type": ["text/html"],
"Server": ["nginx"],
"Set-Cookie": [
        "user=JohnDoe; Max-Age=3600; Secure",
        "session_id=abc123xyz; HttpOnly; Secure",
        "theme=dark; Path=/"
    ]
}
```