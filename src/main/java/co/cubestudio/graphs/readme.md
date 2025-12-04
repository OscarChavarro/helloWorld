# Minimum number of semesters implied by university course prerequisites

You are given a set of university courses and their prerequisite relationships.  
Each course is labeled with an integer from `1` to `n`.

Some courses must be taken before others: if course `a` is a prerequisite of course `b`, then you **must** finish `a` in a semester strictly **before** you can take `b`.

In one semester, you can take **any number of courses** as long as **all of their prerequisites were completed in previous semesters**.

A prerequisite chain is a sequence of distinct courses where each course is a prerequisite of the next one in the sequence.

Your task is to compute the minimum number of semesters needed to complete the longest chain of prerequisites.
Each course in that prerequisite chain must be taken in a different semester, starting from its first prerequisite.

---

## Function Signature

```java
int minNumberOfSemesters(int n, int[][] prerequisites);
```

- `n` — the total number of courses, labeled from `1` to `n`.
- `prerequisites{i} = {a, b}` — to take course `b`, you must first complete course `a`.

---

## Example 1

**Input:**

```text
n = 4
prerequisites = {{1, 2}, {2, 3}, {3, 4}, {1, 4}}
```

**Output:**

```text
4
```

---

## Example 2

**Input:**

```text
n = 4
prerequisites = {}
```

**Output:**

```text
1
```

---

## Example 3

**Input:**

```text
n = 6
prerequisites = {{1, 2}, {2, 3}, {1, 4}, {4, 5}, {5, 6}}
```

**Output:**

```text
4
```

---

## Constraints

- 1 <= n <= 10^5
- 0 <= prerequisites.length <= 10^5
- All course IDs are in the range `{1, n}`.
