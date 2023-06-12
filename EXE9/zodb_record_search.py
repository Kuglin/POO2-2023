from ZODB import DB, FileStorage
import transaction

# Configurar conexão com o banco de dados ZODB
storage = FileStorage.FileStorage('objdb.fs')
db = DB(storage)
connection = db.open()
root = connection.root()

# Buscar registro de número 10.000
registro_10000 = root.get(10000)

if registro_10000:
    print(f"Registro 10.000: {registro_10000.nome}")

# Listar os 5 registros seguintes
registros_seguintes = [root.get(i) for i in range(10001, 10006) if root.get(i)]

for registro in registros_seguintes:
    print(f"Registro seguinte: {registro.nome}")

# Fechar conexões
connection.close()
db.close()
