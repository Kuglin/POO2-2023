from datetime import date
from flask import Flask
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///database.db'
db = SQLAlchemy(app)

# Classe Pessoa usando Flask-SQLAlchemy
class Pessoa(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(50), nullable=False)
    data_nascimento = db.Column(db.Date)

    endereco_id = db.Column(db.Integer, db.ForeignKey('endereco.id'))
    endereco = db.relationship('Endereco', backref='pessoas', uselist=False)


# Classe Endereco usando SQLAlchemy puro (composição)
class Endereco(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    rua = db.Column(db.String(100))
    cidade = db.Column(db.String(50))
    estado = db.Column(db.String(50))
    pais = db.Column(db.String(50))


# Classe Cliente que herda de Pessoa
class Cliente(Pessoa):
    id = db.Column(db.Integer, db.ForeignKey('pessoa.id'), primary_key=True)
    numero_cliente = db.Column(db.String(10))


# Criação das tabelas no banco de dados
db.create_all()


# Operações nos objetos
def incluir():
    # Criar objetos Pessoa e Endereco
    endereco = Endereco(rua='Rua A', cidade='Cidade A', estado='Estado A', pais='País A')
    pessoa = Pessoa(nome='Fulano', data_nascimento=date(1990, 1, 1), endereco=endereco)

    # Inserir no banco de dados
    db.session.add(pessoa)
    db.session.commit()


def consultar_todos():
    # Consultar todas as pessoas
    pessoas = Pessoa.query.all()
    for pessoa in pessoas:
        print(pessoa.nome)


def consultar_filtro():
    # Consultar pessoas com filtro
    pessoas = Pessoa.query.filter_by(nome='Fulano').all()
    for pessoa in pessoas:
        print(pessoa.nome)


def alterar():
    # Alterar nome de uma pessoa
    pessoa = Pessoa.query.filter_by(nome='Fulano').first()
    pessoa.nome = 'Beltrano'
    db.session.commit()


def excluir():
    # Excluir pessoa
    pessoa = Pessoa.query.filter_by(nome='Beltrano').first()
    db.session.delete(pessoa)
    db.session.commit()


# Teste das operações
incluir()
consultar_todos()
consultar_filtro()
alterar()
excluir()
