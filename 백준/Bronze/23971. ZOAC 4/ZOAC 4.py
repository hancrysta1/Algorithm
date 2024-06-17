from math import ceil

h, w, n, m = map(int, input().split())
rows = ceil(h / (n + 1))
cols = ceil(w / (m + 1))
print(rows * cols)