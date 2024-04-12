sub_conjunto([],_).
sub_conjunto([X|Xs],Ys) :- member(X,Ys), sub_conjunto(Xs,Ys).



%sub_conjunto([],[1,2,3,4,5]).
%sub_conjunto([1,2,6],[1,2,3,4,5]).
