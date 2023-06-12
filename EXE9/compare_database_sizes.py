import os

sqlite_size = os.path.getsize('database.db')
zodb_size = os.path.getsize('objdb.fs')

print(f'Tamanho do banco de dados SQLite: {sqlite_size} bytes')
print(f'Tamanho do banco de dados ZODB: {zodb_size} bytes')