longitud([],0).
longitud(Lista,N):-
    Lista = [_|Col],
    longitud(Col,M),
    N is M+1.
posicion([Cabeza|_],1,Cabeza).
posicion([_|Cola],N,X):-
    N>0,
    N1 is N-1,
    posicion(Cola,N1,X1),
    X=X1.
pos(1,4).
pos(2,4).
miembro(X,sol(X,_):-
  X = palabra(Lista),
  pos(1,N),
  longitud(Lista,N).
miembro(X,sol(_,X):-
  X = palabra(Lista),
  pos(2,N),
  longitud(Lista,N).
ubicacion1(X,sol(X,_):-
  X = palabra(Lista),
  pos(1,N),
  longitud(Lista,N).
ubicacion2(X,sol(_,X):-
  X = palabra(Lista),
  pos(2,N),
  longitud(Lista,N).
sol(C):-
ubicacion1(palabra(C,H,A,U),C),
  miembro(palabra([C,H,A,U]),C),
  miembro(palabra([H,O,L,A]),C),
 ubicacion1(palabra(X1),C),
    ubicacion2(palabra(Y1),C),
    posicion(X1,2,Letra1),
    posicion(Y1,1,Letra1).