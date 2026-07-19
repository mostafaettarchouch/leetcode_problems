class Solution {
    fun isValid(s: String): Boolean {
        val bracketMap = mapOf('(' to ')', '{' to '}', '[' to ']')
        val stack = mutableListOf<Char>()
        for (char in s) {
            for (opening in bracketMap.keys) {
                if (char == opening) {
                    stack.add(char)
                }
            }
            for (closing in bracketMap.values) {
                if (char == closing) {
                    if (stack.isEmpty()) {
                        return false
                    }
                    if (bracketMap[stack.removeAt(stack.size - 1)] != char) {
                        return false
                    }
                }
            }
        }
        return stack.isEmpty()
    }
}