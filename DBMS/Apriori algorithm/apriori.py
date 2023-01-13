from collections import defaultdict
from itertools import combinations
import pandas as pd

df = pd.DataFrame(pd.read_csv(
    'D:\\Poralekha\\3-1\\DBMS\\apriori.csv', delimiter=':'))

# min_supp_count = 2
data = []

for _, row in df.iterrows():
    tid = row['TID']
    products = row['PRODUCTS'].split(',')

    data.append([tid, products])

# print(data)

transactions_dict = {}
for entry in data:
    tid = entry[0]
    products = sorted(entry[1])
    transactions_dict[tid] = products

# print(transactions_dict['TID1'][1])
# print(transactions_dict)

counts = defaultdict(int)

for key in transactions_dict:
    for item in transactions_dict[key]:
        counts[item] += 1

# print(counts)
combination_counts = defaultdict(int)

for key in transactions_dict:
    for length in range(1, len(transactions_dict[key])+1):
        for combination in combinations(transactions_dict[key], length):
            combination_counts[combination] += 1

# print(combination_counts)

min_supp_count = int(input("Enter minimum support count: "))

filtered_counts = defaultdict(int)
for k, v in combination_counts.items():
    if v >= min_supp_count:
        filtered_counts[k] = v

print(filtered_counts)


# for i in filtered_counts:
#     print(i.values())
