import matplotlib.pyplot as plt
import sys
import os

def plot(points, savename):
    x, y = zip(*points)
    plt.plot(x, y, 'ro')
    for i in range(0, len(points) - 1):
        plt.plot([points[i][0], points[(i+1)][0]], [points[i][1], points[(i+1)][1]], lw=1, c='blue')
    i = len(points) - 1
    plt.plot([points[i][0], points[0][0]], [points[i][1], points[0][1]], lw=1, c='blue')
    p = os.path.join('target' , savename)
    if not os.path.exists(os.path.dirname(p)):
        os.makedirs(os.path.dirname(p))
    plt.savefig(p)
    plt.show()

if __name__ == "__main__":
    plot([tuple(map(int, i.split(', '))) for i in sys.argv[1][1:-2].replace("(", "").split("), ")], "InputTspPRoblemPlot.png")
    plot([tuple(map(int, i.split(', '))) for i in sys.argv[2][1:-2].replace("(", "").split("), ")], "OutputTspPRoblemPlot.png")