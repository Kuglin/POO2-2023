from ZODB import DB, FileStorage
import transaction
import sqlite3

# Criar conexão com o banco de dados SQLite existente
conn = sqlite3.connect('database.db')
cursor = conn.cursor()

# Configurar novo banco de dados ZODB
storage = FileStorage.FileStorage('objdb.fs')
db = DB(storage)
connection = db.open()
root = connection.root()

# Criar classe Pessoa para representar os registros
class Pessoa:
    def __init__(self, nome, data_nascimento):
        self.nome = nome
        self.data_nascimento = data_nascimento

# Ler registros do banco de dados SQLite e inserir no ZODB
cursor.execute('SELECT * FROM pessoa')
for row in cursor.fetchall():
    nome = row[1]
    data_nascimento = row[2]
    pessoa = Pessoa(nome, data_nascimento)
    root[row[0]] = pessoa

transaction.commit()

# Fechar conexões
cursor.close()
conn.close()
connection.close()
db.close()