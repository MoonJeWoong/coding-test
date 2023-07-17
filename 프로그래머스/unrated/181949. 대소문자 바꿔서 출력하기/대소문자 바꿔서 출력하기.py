str = input()
ans = ""
for c in str:
    if c.isupper():
        ans += c.lower()
    else:
        ans += c.upper()
        
print(ans)