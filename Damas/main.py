from copy import deepcopy 
import random 
import math
from sys import exit 
from graphics import *

turn = 'white' # Mirar de quien es el turno
selected = (0, 1) # posicion de la ficha seleccionada
board = 0 # inicio del tablero
move_limit = [150, 0] # limite del movimiento
best_move = () 
black, white = (), () 
window_size = (700, 700) 
title = 'Checkers JV JP' 
board_size = 8 
fps = 1 
win = GraphWin(title, window_size[0], window_size[1])
board = None

######################## CLASES ########################

# clase que representa la pieza en el tablero
class Piece(object):
	def __init__(self, color, king):
		self.color = color
		self.king = king

# clase que representa el jugador ya sea la cpu o el humano
class Player(object):
	def __init__(self, type, color, strategy, ply_depth):
		self.type = type # cpu o humano
		self.color = color # blanco o negro
		self.strategy = strategy 
		self.ply_depth = ply_depth #profundidad


#funcion para inicializar el tablero
def init_board():
	global move_limit
	move_limit[1] = 0 # restablecer limite de movimiento

	result = [
	[ 0, 1, 0, 1, 0, 1, 0, 1],
	[ 1, 0, 1, 0, 1, 0, 1, 0],
	[ 0, 1, 0, 1, 0, 1, 0, 1],
	[ 0, 0, 0, 0, 0, 0, 0, 0],
	[ 0, 0, 0, 0, 0, 0, 0, 0],
	[-1, 0,-1, 0,-1, 0,-1, 0],
	[ 0,-1, 0,-1, 0,-1, 0,-1],
	[-1, 0,-1, 0,-1, 0,-1, 0]
	] # configuración inicial
	for m in range(8):
		for n in range(8):
			if (result[m][n] == 1):
				piece = Piece('black', False) # piezas negras
				result[m][n] = piece
			elif (result[m][n] == -1):
				piece = Piece('white', False) # piezas blancas
				result[m][n] = piece
	return result

def init_player(type, color, strategy, ply_depth):
	return Player(type, color, strategy, ply_depth)


def avail_moves(board, player):
    moves = [] # saltos y movidas posibles

    #mirar los saltos posibles
    for m in range(8):
        for n in range(8):
            if board[m][n] != 0 and board[m][n].color == player: 
                if can_jump([m, n], [m+1, n+1], [m+2, n+2], board) == True: moves.append([m, n, m+2, n+2])
                if can_jump([m, n], [m-1, n+1], [m-2, n+2], board) == True: moves.append([m, n, m-2, n+2])
                if can_jump([m, n], [m+1, n-1], [m+2, n-2], board) == True: moves.append([m, n, m+2, n-2])
                if can_jump([m, n], [m-1, n-1], [m-2, n-2], board) == True: moves.append([m, n, m-2, n-2])

    if len(moves) == 0: # movidas posibles
        for m in range(8):
            for n in range(8):
                if board[m][n] != 0 and board[m][n].color == player: # for all the players pieces...
                    if can_move([m, n], [m+1, n+1], board) == True: moves.append([m, n, m+1, n+1])
                    if can_move([m, n], [m-1, n+1], board) == True: moves.append([m, n, m-1, n+1])
                    if can_move([m, n], [m+1, n-1], board) == True: moves.append([m, n, m+1, n-1])
                    if can_move([m, n], [m-1, n-1], board) == True: moves.append([m, n, m-1, n-1])

    return moves #lista de los saltos y movidas posibles	

# retorna si el salto es legal
def can_jump(a, via, b, board):
    # si se sale del tablero
    if b[0] < 0 or b[0] > 7 or b[1] < 0 or b[1] > 7:
        return False
    # si se tiene una pieza en esa posicion
    if board[b[0]][b[1]] != 0: return False
    # si se salta algo
    if board[via[0]][via[1]] == 0: return False
    # para las piezas blancas
    if board[a[0]][a[1]].color == 'white':
        if board[a[0]][a[1]].king == False and b[0] > a[0]: return False 
        if board[via[0]][via[1]].color != 'black': return False 
        return True # el salto es posible
    # para las piezas negras
    if board[a[0]][a[1]].color == 'black':
        if board[a[0]][a[1]].king == False and b[0] < a[0]: return False 
        if board[via[0]][via[1]].color != 'white': return False 
        return True # el salto es posible

# retorna si la movida es legal
def can_move(a, b, board):
   
    if b[0] < 0 or b[0] > 7 or b[1] < 0 or b[1] > 7:
        return False
   
    if board[b[0]][b[1]] != 0: return False
   #fichas blancas
    if board[a[0]][a[1]].king == False and board[a[0]][a[1]].color == 'white':
        if b[0] > a[0]: return False 
        return True # move is possible
    # fichas negras
    if board[a[0]][a[1]].king == False and board[a[0]][a[1]].color == 'black':
        if b[0] < a[0]: return False 
        return True 
    
    if board[a[0]][a[1]].king == True: return True 

def make_move(a, b, board):
    board[b[0]][b[1]] = board[a[0]][a[1]] # hace la movida
    board[a[0]][a[1]] = 0 # borra la ficha
    
    # mira si se es rey
    if board[b[0]][b[1]] != 0:
	    if b[0] == 0 and board[b[0]][b[1]].color == 'white': board[b[0]][b[1]].king = True
	    if b[0] == 7 and board[b[0]][b[1]].color == 'black': board[b[0]][b[1]].king = True
	    
    if (a[0] - b[0]) % 2 == 0: # se hace un salto
        board[math.floor((a[0]+b[0])/2)][math.floor((a[1]+b[1])/2)] = 0 # se borra el salto

#evaluar el tablero para cada jugador
def evaluate(game, player):

	#Esta función sólo suma las piezas del tablero (100 = pieza, 175 = rey) y devuelve la diferencia
	def simple_score(game, player):
		black, white = 0, 0 
		for m in range(8):
			for n in range(8):
				if (game[m][n] != 0 and game[m][n].color == 'black'): 
					if game[m][n].king == False: black += 100 
					else: black += 175 
				elif (game[m][n] != 0 and game[m][n].color == 'white'):
					if game[m][n].king == False: white += 100 
					else: white += 175 
		if player != 'black': return white-black
		else: return black-white

  #Esta función agregará bonificación a las piezas que van al lado opuesto
	def piece_rank(game, player):
		black, white = 0, 0 
		for m in range(8):
			for n in range(8):
				if (game[m][n] != 0 and game[m][n].color == 'black'): 
					if game[m][n].king != True: 
						black = black + (m*m)
				elif (game[m][n] != 0 and game[m][n].color == 'white'): 
					if game[m][n].king != True: 
						white = white + ((7-m)*(7-m))
		if player != 'black': return white-black
		else: return black-white

	#Un rey en un borde podría quedar atrapado, así deducir algunos puntos
	def edge_king(game, player):
		black, white = 0, 0 
		for m in range(8):
			if (game[m][0] != 0 and game[m][0].king != False):
				if game[m][0].color != 'white': black += -25
				else: white += -25
			if (game[m][7] != 0 and game[m][7].king != False):
				if game[m][7].color != 'white': black += -25
				else: white += -25
		if player != 'black': return white-black
		else: return black-white
	
	#multi = random.uniform(0.97, 1.03) 

	return (simple_score(game, player) + piece_rank(game, player) + edge_king(game, player)) * 1


def end_game(board):
	black, white = 0, 0 
	for m in range(8):
		for n in range(8):
			if board[m][n] != 0:
				if board[m][n].color == 'black': black += 1 
				else: white += 1 

	return black, white


''' http://en.wikipedia.org/wiki/Minimax '''
''' function minimax(node, depth) '''
def minimax(board, player, ply):
	global best_move

	# find out ply depth for player
	ply_depth = 0
	if player != 'black': ply_depth = white.ply_depth
	else: ply_depth = black.ply_depth

	end = end_game(board)

	''' if node is a terminal node or depth = CutoffDepth '''
	if ply >= ply_depth or end[0] == 0 or end[1] == 0: # are we still playing?
		''' return the heuristic value of node '''
		score = evaluate(board, player) # return evaluation of board as we have reached final ply or end state
		return score
		
	''' if the adversary is to play at node '''
	if player != turn: # if the opponent is to play on this node...
		
		''' let beta := +infinity '''
		beta = +10000
		
		''' foreach child of node '''
		moves = avail_moves(board, player) # get the available moves for player
		for i in range(len(moves)):
			# create a deep copy of the board (otherwise pieces would be just references)
			new_board = deepcopy(board)
			make_move((moves[i][0], moves[i][1]), (moves[i][2], moves[i][3]), new_board) # make move on new board
			
			''' beta := min(beta, minimax(child, depth+1)) '''
			# ...make a switch of players for minimax...
			if player == 'black': player = 'white'
			else: player = 'black'
								
			temp_beta = minimax(new_board, player, ply+1)
			if temp_beta < beta:
				beta = temp_beta # take the lowest beta

		''' return beta '''
		return beta
	
	else: # else we are to play
		''' else {we are to play at node} '''
		''' let alpha := -infinity '''
		alpha = -10000
		
		''' foreach child of node '''
		moves = avail_moves(board, player) # get the available moves for player
		for i in range(len(moves)):
			# create a deep copy of the board (otherwise pieces would be just references)
			new_board = deepcopy(board)
			make_move((moves[i][0], moves[i][1]), (moves[i][2], moves[i][3]), new_board) # make move on new board
							
			''' alpha := max(alpha, minimax(child, depth+1)) '''							
			# ...make a switch of players for minimax...
			if player == 'black': player = 'white'
			else: player = 'black'
			
			temp_alpha = minimax(new_board, player, ply+1)
			if temp_alpha > alpha:
				alpha = temp_alpha # take the highest alpha
				if ply == 0: best_move = (moves[i][0], moves[i][1]), (moves[i][2], moves[i][3]) # save the move as it's our turn

		''' return alpha '''
		return alpha


''' http://www.ocf.berkeley.edu/~yosenl/extras/alphabeta/alphabeta.html '''
''' alpha-beta(player,board,alpha,beta) '''
def alpha_beta(player, board, ply, alpha, beta):
	global best_move

	# find out ply depth for player
	ply_depth = 0
	if player != 'black': ply_depth = white.ply_depth
	else: ply_depth = black.ply_depth

	end = end_game(board)

	''' if(game over in current board position) '''
	if ply >= ply_depth or end[0] == 0 or end[1] == 0: # are we still playing?
		''' return winner '''
		score = evaluate(board, player) # return evaluation of board as we have reached final ply or end state
		return score

	''' children = all legal moves for player from this board '''
	moves = avail_moves(board, player) # get the available moves for player

	''' if(max's turn) '''
	if player == turn: # if we are to play on node...
		''' for each child '''
		for i in range(len(moves)):
			# create a deep copy of the board (otherwise pieces would be just references)
			new_board = deepcopy(board)
			make_move((moves[i][0], moves[i][1]), (moves[i][2], moves[i][3]), new_board) # make move on new board

			''' score = alpha-beta(other player,child,alpha,beta) '''
			# ...make a switch of players for minimax...
			if player == 'black': player = 'white'
			else: player = 'black'

			score = alpha_beta(player, new_board, ply+1, alpha, beta)

			''' if score > alpha then alpha = score (we have found a better best move) '''
			if score > alpha:
				if ply == 0: best_move = (moves[i][0], moves[i][1]), (moves[i][2], moves[i][3]) # save the move
				alpha = score
			''' if alpha >= beta then return alpha (cut off) '''
			if alpha >= beta:
				#if ply == 0: best_move = (moves[i][0], moves[i][1]), (moves[i][2], moves[i][3]) # save the move
				return alpha

		''' return alpha (this is our best move) '''
		return alpha

	else: # the opponent is to play on this node...
		''' else (min's turn) '''
		''' for each child '''
		for i in range(len(moves)):
			# create a deep copy of the board (otherwise pieces would be just references)
			new_board = deepcopy(board)
			make_move((moves[i][0], moves[i][1]), (moves[i][2], moves[i][3]), new_board) # make move on new board

			''' score = alpha-beta(other player,child,alpha,beta) '''
			# ...make a switch of players for minimax...
			if player == 'black': player = 'white'
			else: player = 'black'

			score = alpha_beta(player, new_board, ply+1, alpha, beta)

			''' if score < beta then beta = score (opponent has found a better worse move) '''
			if score < beta: beta = score
			''' if alpha >= beta then return beta (cut off) '''
			if alpha >= beta: return beta
		''' return beta (this is the opponent's best move) '''
		return beta

def end_turn():
	global turn 
	if turn != 'black':	turn = 'black'
	else: turn = 'white'

def winner(color):
	global board
	for m in range(8):
		for n in range(8):
			if board[m][n] != 0:
				if board[m][n].color == 'color': board[m][n] = 0
		

def cpu_play(player):
	global board, move_limit 

	
	if player.strategy == 'minimax': alpha = minimax(board, player.color, 0)
	elif player.strategy == 'alpha-beta': alpha = alpha_beta(player.color, board, 0, -10000, +10000)
	
	
	if alpha == -10000: 
		if player.color == white: winner("black")
		else: winner("white")

	make_move(best_move[0], best_move[1], board) 

	move_limit[1] += 1 

	end_turn() 


def ply_check():
	global black, white
	if black.type != 'cpu': black.ply_depth = white.ply_depth
	elif white.type != 'cpu': white.ply_depth = black.ply_depth


def player_check():
	global black, white

	if black.type != 'cpu' or black.type != 'human': black.type = 'cpu'
	if white.type != 'cpu' or white.type != 'human': white.type = 'cpu'

	if black.ply_depth <0: black.ply_depth = 1
	if white.ply_depth <0: white.ply_depth = 1

	if black.color != 'black': black.color = 'black'
	if white.color != 'white': white.color = 'white'

	if black.strategy != 'minimax':
		if black.strategy != 'alpha-beta': black.strategy = 'alpha-beta'
	if white.strategy != 'minimax':
		if white.strategy != 'alpha-beta': white.strategy = 'alpha-beta'


def game_init(modo):
	global black, white 
	if modo == 1:
		black = init_player('cpu', 'black', 'alpha-beta', 5) 
		white = init_player('human', 'white', 'alpha-beta', 5) 
	if modo == 2:
		black = init_player('cpu', 'black', 'alpha-beta', 5) 
		white = init_player('cpu', 'white', 'alpha-beta', 5) 
	board = init_board()
	return board			

def draw_piece(row, column, color, king):

	posX = ((window_size[0]/8)*column) - (window_size[0]/8)/2
	posY = ((window_size[1]/8)*row) - (window_size[1]/8)/2
		
	c = Circle(Point(int(posX),int(posY)), 30) 
	c.setFill(color)
	c.draw(win)

	#dibujar el rey
	if king == True:
		c = Circle(Point(int(posX+3),int(posY-3)), 30) 
		c.setFill(color)
		c.draw(win)


def mouse_click(pos):
	global selected, move_limit 
	
	if (turn != 'black' and white.type != 'cpu') or (turn != 'white' and black.type != 'cpu'):
		column = int(pos[0]/(window_size[0]/board_size))
		row = int(pos[1]/(window_size[1]/board_size))

		if board[row][column] != 0 and board[row][column].color == turn:
			selected = row, column 
		else:
			moves = avail_moves(board, turn) 
			for i in range(len(moves)):
				if selected[0] == moves[i][0] and selected[1] == moves[i][1]:
					if row == moves[i][2] and column == moves[i][3]:
						make_move(selected, (row, column), board) 
						move_limit[1] += 1 
						end_turn() 


#Juego CPU vs Jugador
def CPUvsPlayer():
	global board
	board = game_init(1) 
	Terminar = False
	ply_check() 

	while not Terminar:
		background0 = Image(Point(0,0), "Board.gif") # cargar tablero
		background1 = Image(Point(window_size[0],0), "Board.gif")
		background2 = Image(Point(0,window_size[0]), "Board.gif")
		background3 = Image(Point(window_size[0], window_size[1]), "Board.gif")
		background0.draw(win)
		background1.draw(win)
		background2.draw(win)
		background3.draw(win)

		for m in range(8):
			for n in range(8):
				if board[m][n] != 0:
					draw_piece(m+1, n+1, board[m][n].color, board[m][n].king)

		mouse = win.getMouse()
		if(mouse != None):
			pos = [int(mouse.getX()), int(mouse.getY())]
			mouse_click(pos)

		# mirar estado del juego
		end = end_game(board)
		if end[1] == 0:	
			message = Text(Point(window_size[0]/2,window_size[0]/2), "Gano la CPU")
			message.setStyle("bold")
			message.setTextColor("red")
			message.setSize(30)
			message.draw(win)
			Terminar = True
		elif end[0] == 0:
			message = Text(Point(window_size[0]/2,window_size[0]/2), "Gano el Jugador")
			message.setStyle("bold")
			message.setTextColor("red")
			message.setSize(30)
			message.draw(win) 
			Terminar = True
		# juega la cpu
		if turn != 'black' and white.type == 'cpu': cpu_play(white) 
		elif turn != 'white' and black.type == 'cpu': cpu_play(black) 
		update(fps)
	
#Juego CPU vs CPU
def CPUvsCPU():
	global board
	board = game_init(2) 
	Terminar = False
	ply_check() 

	while not Terminar:
		background0 = Image(Point(0,0), "Board.gif") # cargar tablero
		background1 = Image(Point(window_size[0],0), "Board.gif")
		background2 = Image(Point(0,window_size[0]), "Board.gif")
		background3 = Image(Point(window_size[0], window_size[1]), "Board.gif")
		background0.draw(win)
		background1.draw(win)
		background2.draw(win)
		background3.draw(win)

		for m in range(8):
			for n in range(8):
				if board[m][n] != 0:
					draw_piece(m+1, n+1, board[m][n].color, board[m][n].king)

		mouse = win.checkMouse()

		# mirar estado del juego
		end = end_game(board)
		if end[1] == 0:	
			message = Text(Point(window_size[0]/2,window_size[0]/2), "Ganan Blancas")
			message.setStyle("bold")
			message.setTextColor("red")
			message.setSize(30)
			message.draw(win)
			Terminar = True
		elif end[0] == 0:
			message = Text(Point(window_size[0]/2,window_size[0]/2), "Ganan Negras")
			message.setStyle("bold")
			message.setTextColor("red")
			message.setSize(30)
			message.draw(win) 
			Terminar = True
		# juega la cpu
		if turn != 'black' and white.type == 'cpu': cpu_play(white) 
		elif turn != 'white' and black.type == 'cpu': cpu_play(black) 
		update(fps)

#Inicio
if __name__ == '__main__':
	Terminar = False
	while not Terminar:
		msg1 = Text(Point(window_size[0]/2, window_size[0]/3-50), "Player vs CPU")
		msg1.draw(win)
		msg2 = Text(Point(window_size[0]/2, 2*window_size[0]/3-50), "CPU vs CPU")
		msg2.draw(win)
		msg3 = Text(Point(window_size[0]/2, 3*window_size[0]/3-50), "Salir")
		msg3.draw(win)
		mouse = win.checkMouse()
		if(mouse != None):
			pos = [int(mouse.getX()), int(mouse.getY())]
			if(pos[0] >= 290.0 and pos[0] <= 400.0):
				if(pos[1] >= 175.0 and pos[1] <= 195.0):
					CPUvsPlayer()
				if(pos[1] >= 410.0 and pos[1] <= 430.0):
					CPUvsCPU()
				if(pos[1 ]>= 640.0 and pos[1] <= 660.0):
					Terminar = True
	win.close()


