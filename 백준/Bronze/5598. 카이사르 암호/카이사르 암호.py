modi_words=['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
ex_words=['D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C']

words = list(input())
word=''
for i,data in enumerate(words):
    indexing=ex_words.index(data)
    word+=modi_words[indexing]

print(word)